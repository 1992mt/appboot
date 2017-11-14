package com.app.common.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

/**
 * 文件工具类
 * @author mt
 *
 */
public class FileUtil {

	private static Logger LOG = LoggerFactory.getLogger(FileUtil.class);
	private static int expireTime = 10 * 60 * 1000;// 过期时间10分钟
	
	/**
	 * 文件追加内容
	 * @param filePath
	 * @throws Exception 
	 */
	 public static void WriteStringToFile(String filePath,String filename,String content) throws Exception {
		 BufferedWriter bw=null;
		 OutputStreamWriter writerStream=null;
	        try {
	        	File file = new File(filePath);
	        	if(!file.exists()){
	        		file.mkdirs();
	        	}
	        	 writerStream = new OutputStreamWriter(new FileOutputStream(filePath+File.separator+filename,true),"UTF-8");
//	            FileWriter fw = new FileWriter(filePath+File.separator+filename, true);
	             bw = new BufferedWriter(writerStream);
	            bw.write("\r\n");
	            bw.append(content);// 往已有的文件上添加字符串
	            bw.flush();
//	            fw.close();
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	          throw new Exception(e.getMessage());
	        }finally{
	        	if(null!=bw){
	        		 bw.close();
	        	}
	        	if(null!=writerStream){
	        		writerStream.close();
	        	}
	        }
	    }
	 
	 /**
	  * 创建word文档
	  * @param filePath
	  * @param filename
	  * @param content
	 * @throws Exception 
	  */
	 public static void createDoc(String filePath,String filename,String content) throws Exception{
		 ByteArrayInputStream byteStream = null;
		 FileOutputStream outStream = null;
		 Writer out = null;  
		 try ( FileOutputStream outf=new FileOutputStream(filePath+File.separator+filename);){
			 File outFile = new File(filePath+File.separator+filename);  
			 if(!outFile.exists()){
				 outFile.createNewFile();
			 }
			 outf.write(content.getBytes("GBK"));
			 
/*//			    outf.write(content.getBytes());
//			    outf.flush();
			 File outFile = new File(filePath+File.separator+filename);  
			 outFile.createNewFile();
		     out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile)));  
		     out.write(content);
		     out.flush();
//			//创建word文档
			 POIFSFileSystem poifSystem = new POIFSFileSystem(); //暂时不知道什么意思
			 DirectoryNode root = poifSystem.getRoot(); //同上
			 byte[] contentBytes = content.getBytes();
			 byteStream = new ByteArrayInputStream(contentBytes);
			 root.createDocument("WordDocument",byteStream); //这个WordDocument 不可以进行修改 否则乱码
			 outStream = new FileOutputStream(outFile); 
			 poifSystem.writeFilesystem(outStream); //将流 输出到word文档上
*/		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			/*if(null!=outf){
				outf.close;
			}*/
			if(null!=out){
				out.close();
			}
			if(null!=byteStream){
				byteStream.close();
			}
			if(null!=outStream){
				outStream.close();
			}
		}
	 }
	
	/**
	 * 
	* @Title: delFile
	* @Description:删除folderPath下所有文件名包含fileNameStr字符串的文件
	* @return void    返回类型
	* @param folderPath
	* @param fileNameStr
	* @param mode debug模式标识
	 */
	public static void delFile(String folderPath, final String fileNameStr, String mode) {
		if ("1".equals(mode)) {
			LOG.debug("当前为调试模式，文件保留，不执行删除操作");
			return;
		}
		if (StringUtils.isEmpty(fileNameStr))
			return;
		File fileDir = new File(folderPath);
		File[] files = fileDir.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.contains(fileNameStr);
			}
		});
		if(files != null && files.length >0 ){
			for (File file : files) {
				String flagDesc = file.delete()?"成功":"失败";
				LOG.debug("删除文件"+flagDesc+"，文件 ==>  " + file.getAbsolutePath());
			}
		}
	}

	/**
	 * 文件拷贝
	 * 
	 * @param orderId
	 * @param srcPath
	 * @param destPath
	 * @param baseYjService
	 * @param fwxmmc
	 */
	public static boolean copyPic2Archive(String orderId, String srcPath,
			String destPath, String fwxmmc, String ip, int pageNums) {
		boolean copyFlag = true;
		File srcPathFile = new File(srcPath);
		if (!srcPathFile.exists())
			srcPathFile.mkdirs();
		File destPathFile = new File(destPath);
		if (!destPathFile.exists())
			destPathFile.mkdirs();
		for (int idx = 0; idx < pageNums; idx++) {
			String srcName = srcPath + orderId;
			String destName = destPath + orderId;
			if (idx == 0) {
				srcName += ".jpg";
				destName += ".jpg";
			} else {
				srcName += "_" + idx + ".jpg";
				destName += "_" + idx + ".jpg";
			}
			File fileSrc = new File(srcName);
			if (fileSrc.exists()) {
				File fileDest = new File(destName);
				LOG.debug("归档文件，文件 ==> " + destName);
				boolean flag = fileSrc.renameTo(fileDest);
				copyFlag = copyFlag && flag;
			}
		}
		return copyFlag;
	}

	/**
	 * 删除过期没有及时删除的文件
	 * 
	 * @param basePath
	 * @param now
	 */
	public static void delFileOutOfTime(String basePath, Date now) {
		File fileDir = new File(basePath);
		File[] files = fileDir.listFiles();
		if (files != null) {
			for (int idx = 0; idx < files.length; idx++) {
				File f = files[idx];
				if (f.exists()) {
					if (now.getTime() - f.lastModified() >= expireTime) {
						boolean flag = f.delete();
						if (flag) {
							LOG.debug("删除文件成功，文件 ==> " + basePath + f.getName());
						} else {
							LOG.debug("删除文件失败，文件 ==>  " + basePath
									+ f.getName());
						}
					}
				}
			}
		}
	}

	/**
	 * 移动指定文件或文件夹(包括所有文件和子文件夹)
	 * 
	 * @param fromDir
	 *            要移动的文件或文件夹
	 * @param toDir
	 *            目标文件夹
	 * @throws Exception
	 */
	public static void moveFolderAndFileWithSelf(String from, String to)
			throws Exception {
		try {
			File dir = new File(from);
			// 目标
			to += File.separator + dir.getName();
			File moveDir = new File(to);
			if (dir.isDirectory()) {
				if (!moveDir.exists()) {
					moveDir.mkdirs();
				}
			} else {
				File tofile = new File(to);
				dir.renameTo(tofile);
				return;
			}

			// 文件一览
			File[] files = dir.listFiles();
			if (files == null)
				return;

			// 文件移动
			for (int i = 0; i < files.length; i++) {
				if (files[i].isDirectory()) {
					moveFolderAndFileWithSelf(files[i].getPath(), to);
					// 成功，删除原文件
					files[i].delete();
				}
				File moveFile = new File(moveDir.getPath() + File.separator
						+ files[i].getName());
				// 目标文件夹下存在的话，删除
				if (moveFile.exists()) {
					moveFile.delete();
				}
				files[i].renameTo(moveFile);
			}
			dir.delete();
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * 复制单个文件(可更名复制)
	 * 
	 * @param oldPathFile
	 *            准备复制的文件源
	 * @param newPathFile
	 *            拷贝到新绝对路径带文件名(注：目录路径需带文件名)
	 * @return
	 * @throws IOException
	 * 
	 */
	@Deprecated
	public static void copySingleFile(String oldPathFile, String newPathFile)
			throws IOException {
		FileOutputStream fs = null;
		InputStream inStream = null;
		try {
			int byteread = 0;
			File oldfile = new File(oldPathFile);
			if (oldfile.exists()) { // 文件存在时
				inStream = new FileInputStream(oldPathFile); // 读入原文件
				fs = new FileOutputStream(newPathFile);
				byte[] buffer = new byte[1444];
				while ((byteread = inStream.read(buffer)) != -1) {
					fs.write(buffer, 0, byteread);
				}
			}
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		} finally {
			if (fs != null) {
				fs.close();
			}
			if (inStream != null) {
				inStream.close();
			}
		}

	}

	/**
	 * 复制单个文件(原名复制)
	 * 
	 * @param oldPathFile
	 *            准备复制的文件源
	 * @param targetPath
	 *            拷贝到新绝对路径不带文件名
	 * @return
	 */
	@Deprecated
	public static void copySingleFileTo(String oldPathFile, String targetPath) {
		try {
			int byteread = 0;
			File oldfile = new File(oldPathFile);
			String targetfile = targetPath + File.separator + oldfile.getName();
			if (oldfile.exists()) { // 文件存在时
				InputStream inStream = new FileInputStream(oldPathFile); // 读入原文件
				FileOutputStream fs = new FileOutputStream(targetfile);
				byte[] buffer = new byte[1444];
				while ((byteread = inStream.read(buffer)) != -1) {
					fs.write(buffer, 0, byteread);
				}
				inStream.close();
			}
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
	}

	/**
	 * 复制整个文件夹的内容(含自身)
	 * 
	 * @param oldPath
	 *            准备拷贝的目录
	 * @param newPath
	 *            指定绝对路径的新目录
	 * @return
	 */
	public static void copyFolderWithSelf(String oldPath, String newPath) {
		try {
			new File(newPath).mkdirs(); // 如果文件夹不存在 则建立新文件夹
			File dir = new File(oldPath);
			// 目标
			newPath += File.separator + dir.getName();
			File moveDir = new File(newPath);
			if (dir.isDirectory()) {
				if (!moveDir.exists()) {
					moveDir.mkdirs();
				}
			}
			String[] file = dir.list();
			File temp = null;
			for (int i = 0; i < file.length; i++) {
				if (oldPath.endsWith(File.separator)) {
					temp = new File(oldPath + file[i]);
				} else {
					temp = new File(oldPath + File.separator + file[i]);
				}
				if (temp.isFile()) {
					FileInputStream input = new FileInputStream(temp);
					FileOutputStream output = new FileOutputStream(newPath
							+ "/" + (temp.getName()).toString());
					byte[] b = new byte[1024 * 5];
					int len;
					while ((len = input.read(b)) != -1) {
						output.write(b, 0, len);
					}
					output.flush();
					output.close();
					input.close();
				}
				if (temp.isDirectory()) { // 如果是子文件夹
					copyFolderWithSelf(oldPath + "/" + file[i], newPath);
				}
			}
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
	}

	/**
	 * 将流转成文件
	 * 
	 * @param ins
	 * @param file
	 */
	public static void isToFile(InputStream ins, File file,String FileName,String contenStr) {
		OutputStream os = null;
		/*InputStreamReader rd = null;
		OutputStreamWriter osw = null;*/
		try {
			if(!file.exists()){
				file.mkdirs();
			}
			File TempFile = new File(file.getAbsolutePath()+File.separator+FileName);
//			rd = new InputStreamReader(ins);
			os = new FileOutputStream(TempFile);
//			osw=new OutputStreamWriter(os, "utf-8"); 
			int read = 0;
			byte[] buffer = new byte[8192];
			while ((read = ins.read(buffer, 0, 8192)) != -1) {
				os.write(buffer, 0, read);
			}
			/*if(!StringUtils.isEmpty(contenStr)){
				byte[] bytes = ("\r\n"+contenStr).getBytes("UTF-8");
				os.write(bytes, 0, bytes.length);
			}*/
				os.flush();
			/*char[] buffer=new char[8*1024];
			 while((read=rd.read(buffer,0,buffer.length))!=-1){  
		            String s=new String(buffer,0,read);  
		            System.out.println(s);  
		            osw.write(buffer, 0,read);  
		            osw.flush();  
		        }  
			*/

		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		} finally {
			try {
				/*if(osw!=null){
					osw.close();
				}
				if(null!=rd){
					rd.close();
				}*/
				if (os != null) {
					os.close();
				}
				if (ins != null) {
					ins.close();
				}
			} catch (IOException e) {
				LOG.error(e.getMessage(), e);
			}

		}
	}
	
	/**
	 * 将流转成文件
	 * 
	 * @param ins
	 * @param file
	 */
	public static void isToFile(HttpSession session ,long size,InputStream ins, File file) {
		OutputStream os = null;
		try {
			double persent=0d;
			long length = size;
			long readBytes=0L;
			os = new FileOutputStream(file);
			int bytesRead = 0;
			byte[] buffer = new byte[8192];
			while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
				readBytes+=bytesRead;
				persent=readBytes/(double)length*100d;
				os.write(buffer, 0, bytesRead);
				session.setAttribute("percent", Math.round(persent)+"");
			}
			if(readBytes==length){
				session.removeAttribute("percent");
			}

		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		} finally {
			try {
				if (os != null) {
					os.close();
				}
				if (ins != null) {
					ins.close();
				}
			} catch (IOException e) {
				LOG.error(e.getMessage(), e);
			}

		}
	}

	/**
	 * 删除文件
	 * 
	 * @param filePath
	 * @return
	 */
	public static boolean deleteFile(String filePath) {
		if (filePath == null || "".equals(filePath)) {
			return false;
		}
		File file = new File(filePath);
		File parentFile = file.getParentFile();
		if (file.exists()) {
			file.delete();
		}
		if (parentFile.exists() && parentFile.list().length == 0) {
			parentFile.delete();
		}
		return true;
	}

/**
 * 把文件转化为byte数组
 * @param file
 * @return
 * @throws IOException
 */
	public static byte[] getFileBytes(File file) throws IOException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream(
				(int) file.length());
		BufferedInputStream in = null;
		try {
			in = new BufferedInputStream(new FileInputStream(file));
			int buf_size = 1024;
			byte[] buffer = new byte[buf_size];
			int len = 0;
			while (-1 != (len = in.read(buffer, 0, buf_size))) {
				bos.write(buffer, 0, len);
			}
			return bos.toByteArray();
		} catch (IOException e) {
			LOG.error(e.getMessage(), e);
			throw e;
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				LOG.error(e.getMessage(), e);
			}
			bos.close();
		}
	}

/**
 * 删除目录下所有文件
 * @param file
 */
	public static void deleteFile(File file) {
		if (file.exists()) {// 判断文件是否存在
			if (file.isFile()) {// 判断是否是文件
				file.delete();// 删除文件
			} else if (file.isDirectory()) {// 否则如果它是一个目录
				File[] files = file.listFiles();// 声明目录下所有的文件 files[];
				for (int i = 0; i < files.length; i++) {// 遍历目录下所有的文件
					deleteFile(files[i]);// 把每个文件用这个方法进行迭代
				}
				file.delete();// 删除文件夹
			}
		}
	}

	/**
	 * @param args
	 * @throws Exception
	 */
/*	public static void main(String[] args) throws Exception {
		// copySingleFile("E:\\AppSolution.xml", "E:\\test.xml");
		String fileName = "123.txt";
		System.out.println(getFileName(fileName));
	}*/

/**
 * 获取文件后缀名
 * @param fileName
 * @return
 * @throws Exception
 */
	public static String getFileType(String fileName) throws Exception {
		String[] split = fileName.split("\\.");
		String fileType = "";
		if (split.length > 1) {
			fileType = split[split.length - 1];
		} else {
			fileType = fileName;
		}
		return fileType;
	}

	public static String getFileName(String fileName) throws Exception {
		String[] split = fileName.split("\\.");
		StringBuilder fileNamePix = new StringBuilder();
		if (split.length > 1) {
			for (int i = 0; i < split.length - 1; i++) {
				fileNamePix.append(split[i]);
				if (i < split.length - 2) {
					fileNamePix.append(".");
				}
			}
		} else {
			fileNamePix.append(fileName);
		}
		return fileNamePix.toString();
	}
	
/**
 * 读取文件
 * @param classpath
 * @return
 */
	public static String readFile(String classpath){
		InputStream is = null;
			BufferedReader br = null;
			InputStreamReader isr = null;
			StringBuffer sb = new StringBuffer();
			try {
				is = FileUtil.class.getClassLoader().getResourceAsStream(classpath);
				isr = new InputStreamReader(is, "utf-8");
				br = new BufferedReader(isr);  
				String s="";   
				while((s=br.readLine())!=null){  
				           sb.append(s);   
				}
			} catch (Exception e1) {
				LOG.error("",e1);
			}    
			if(is != null){
				try {
					is.close();
				} catch (IOException e) {
				}
			}
			if(br != null){
				try {
					br.close();
				} catch (IOException e) {
				}
			}
			if(isr != null){
				try {
					isr.close();
				} catch (IOException e) {
				}
			}
			return sb.toString();
	}

	
	public static void main(String[] args) {
		//FileUtil.isToFile(file.getInputStream(),new File(filePathDetail),user.getUsername()+TimeUtil.getCurrentTime()+file.getOriginalFilename());
		try {
//			FileUtil.WriteStringToFile("C:\\experience\\mt","text.txt","测试内容");
			FileUtil.createDoc("C:\\experience\\mt","text.doc","测ty1");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
