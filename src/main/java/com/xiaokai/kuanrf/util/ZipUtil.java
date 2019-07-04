package com.xiaokai.kuanrf.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * 解压ZIP压缩文件到指定的目录
 */
public final class ZipUtil {
	/**
	 * 缓存区大小默认20480
	 */
	private final static int FILE_BUFFER_SIZE = 20480;

	/**
	 * 
	 */
	private ZipUtil() {

	}

	/**
	 * 将指定目录的ZIP压缩文件解压到指定的目录
	 * 
	 * @param zipFilePath
	 *            ZIP压缩文件的路径
	 * @param zipFileName
	 *            ZIP压缩文件名字
	 * @param targetFileDir
	 *            ZIP压缩文件要解压到的目录
	 * @return flag 布尔返回值
	 */
	public static boolean unzip(String zipFilePath, String zipFileName,
			String targetFileDir) {
		boolean flag = false;
		// 1.判断压缩文件是否存在，以及里面的内容是否为空
		File file = null; // 压缩文件(带路径)
		ZipFile zipFile = null;
		file = new File(zipFilePath + "/" + zipFileName);
		if (false == file.exists()) {
			return false;
		} else if (0 == file.length()) {
			return false;
		} else {
			// 2.开始解压ZIP压缩文件的处理
			byte[] buf = new byte[FILE_BUFFER_SIZE];
			int readSize = -1;
			ZipInputStream zis = null;
			FileOutputStream fos = null;
			try {
				// 检查是否是zip文件
				zipFile = new ZipFile(file);
				zipFile.close();
				// 判断目标目录是否存在，不存在则创建
				File newdir = new File(targetFileDir);
				if (false == newdir.exists()) {
					newdir.mkdirs();
					newdir = null;
				}
				zis = new ZipInputStream(new FileInputStream(file));
				ZipEntry zipEntry = zis.getNextEntry();
				// 开始对压缩包内文件进行处理
				while (null != zipEntry) {
					String zipEntryName = zipEntry.getName().replace('\\', '/');
					// 判断zipEntry是否为目录，如果是，则创建
					if (zipEntry.isDirectory()) {
						int indexNumber = zipEntryName.lastIndexOf('/');
						File entryDirs = new File(targetFileDir + "/"
								+ zipEntryName.substring(0, indexNumber));
						entryDirs.mkdirs();
						entryDirs = null;
					} else {
						try {
							fos = new FileOutputStream(targetFileDir + "/"
									+ zipEntryName);
							while ((readSize = zis.read(buf, 0,
									FILE_BUFFER_SIZE)) != -1) {
								fos.write(buf, 0, readSize);
							}
						} catch (Exception e) {
							e.printStackTrace();
							throw new RuntimeException(e.getCause());
						} finally {
							try {
								if (null != fos) {
									fos.close();
								}
							} catch (IOException e) {
								e.printStackTrace();
								throw new RuntimeException(e.getCause());
							}
						}
					}
					zipEntry = zis.getNextEntry();
				}
				flag = true;
			} catch (ZipException e) {
				e.printStackTrace();
				throw new RuntimeException(e.getCause());
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException(e.getCause());
			} finally {
				try {
					if (null != zis) {
						zis.close();
					}
					if (null != fos) {
						fos.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
					throw new RuntimeException(e.getCause());
				}
			}
		}
		return flag;
	}

	/**
	 * 功能：把 sourceDir 目录下的所有文件进行 zip 格式的压缩，保存为指定 zip 文件
	 * 
	 * @param sourceDir
	 *            如果是目录，eg：D:\\MyEclipse\\first\\testFile，则压缩目录下所有文件；
	 *            如果是文件，eg：D:\\MyEclipse\\first\\testFile\\aa.zip，则只压缩本文件
	 * @param zipFile
	 *            最后压缩的文件路径和名称,eg:D:\\MyEclipse\\first\\testFile\\aa.zip
	 */
	public static File doZip(String sourceDir, String zipFilePath)
			throws IOException {

		File file = new File(sourceDir);
		File zipFile = new File(zipFilePath);
		ZipOutputStream zos = null;
		try {
			// 创建写出流操作
			OutputStream os = new FileOutputStream(zipFile);
			BufferedOutputStream bos = new BufferedOutputStream(os);
			zos = new ZipOutputStream(bos);

			String basePath = null;

			// 获取目录
			if (file.isDirectory()) {
				basePath = file.getPath();
			} else {
				basePath = file.getParent();
			}

			zipFile(file, basePath, zos);
		} finally {
			if (zos != null) {
				zos.closeEntry();
				zos.close();
			}
			File[] delFile=file.listFiles();  
	        int length = delFile.length;  
	        for(int j=0;j<length;j++){
	            delFile[j].delete();
	        }
	        file.delete();
		}

		return zipFile;
	}

	/**
	 * @param source
	 *            源文件
	 * @param basePath
	 * @param zos
	 */
	private static void zipFile(File source, String basePath,
			ZipOutputStream zos) throws IOException {
		File[] files = null;
		if (source.isDirectory()) {
			files = source.listFiles();
		} else {
			files = new File[1];
			files[0] = source;
		}

		InputStream is = null;
		BufferedInputStream bis = null;
		String pathName;
		byte[] buf = new byte[1024];
		int length = 0;
		for (File file : files) {
			try {
				if (file.isDirectory()) {
					pathName = file.getPath().substring(basePath.length() + 1)
							+ "/";
					zos.putNextEntry(new ZipEntry(pathName));
					zipFile(file, basePath, zos);
				} else {
					pathName = file.getPath().substring(basePath.length() + 1);
					is = new FileInputStream(file);
					bis = new BufferedInputStream(is);
					zos.putNextEntry(new ZipEntry(pathName));
					while ((length = bis.read(buf)) > 0) {
						zos.write(buf, 0, length);
					}
				}
			} finally {
				if (bis != null) {
					bis.close();
				}
				if (is != null) {
					is.close();
				}
			}
		}
	}
	
}