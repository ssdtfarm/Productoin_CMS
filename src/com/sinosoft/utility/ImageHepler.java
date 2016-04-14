package com.sinosoft.utility;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

public class ImageHepler {

	/**
	 * @Description: 将srcImageFile裁剪后生成destImageFile
	 * @param srcImageFile
	 *            原始图
	 * @param destImageFile
	 *            目标图
	 * @param width
	 *            原始图预处理后width
	 * @param height
	 *            原始图预处理后height
	 * @param rect
	 *            目标图输出的格式(rect.x, rect.y, rect.width, rect.height)
	 * @throws IOException
	 
	 */

	public static void cut(BufferedImage bufferedImage, String destImageFile,
			int width, int height, Rectangle rect) {

		// 把原始图片输出
		// ImageIO.write(bImage, "jpg",new File("img/src2.jpg"));

		try {
			File f=new File(destImageFile);
			 
	 
			saveSubImage(bufferedImage, rect, f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static BufferedImage getBufferedImage(InputStream inputStream) {
		
		Image image = null;
		BufferedImage bImage = null;
		try {
		 

				image = ImageIO.read(inputStream);
			 
		 
			
			
			

			bImage = new BufferedImage(image.getWidth(null), image
					.getHeight(null), 1);
			Graphics g = bImage.getGraphics();
			g.drawImage(image.getScaledInstance(image.getWidth(null), image
					.getHeight(null), 4), 0, 0, null);
			 

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return bImage;
		
	}   

	/**
	 * @param filePath
	 * @return BufferedImage
	 * @author liuzq
	 */
	public static BufferedImage getBufferedImage(String filePath) {
		Image image = null;
		BufferedImage bImage = null;
		System.out.println("ImageHepler->filePath="+filePath);
		try {
			if (filePath.startsWith("http://")) {

				image = ImageIO.read(new URL(filePath));
			 
			} else {
				image = ImageIO.read(new File(filePath));
			}

 
			

			bImage = new BufferedImage(image.getWidth(null), image
					.getHeight(null), 1);
			Graphics g = bImage.getGraphics();
			g.drawImage(image.getScaledInstance(image.getWidth(null), image
					.getHeight(null), 4), 0, 0, null);
			 

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return bImage;
	}
	
	

	/**
	 * @Description: 将srcImageFile裁剪后生成destImageFile
	 * @param srcImageFile
	 *            原始图
	 * @param destImageFile
	 *            目标图
	 * @param width
	 *            原始图预处理后width
	 * @param height
	 *            原始图预处理后height
	 * @param rect
	 *            目标图输出的格式(rect.x, rect.y, rect.width, rect.height)
	 * @throws IOException
	 
	 */
	public static void cut(File srcImageFile, File destImageFile, int width,
			int height, Rectangle rect) throws IOException {
		Image image = ImageIO.read(srcImageFile);
		BufferedImage bImage = makeThumbnail(image, width, height);

		saveSubImage(bImage, rect, destImageFile);
	}

	/**
	 * @Description: 对原始图片根据(x, y, width, height) = (0, 0, width,
	 *               height)进行缩放，生成BufferImage
	 * @param img
	 * @param width
	 *            预处理后图片的宽度
	 * @param height
	 *            预处理后图片高度
	 * @return
 
	 * 
	 * @throws IOException
	 */
	private static BufferedImage makeThumbnail(Image img, int width, int height)
			throws IOException {
		int _width = width;
		int _height = height;

		BufferedImage tag = null;
		if (_width == 0 || _height == 0) {
			_width = img.getWidth(null);
			_height = img.getHeight(null);

		}
		tag = new BufferedImage(_width, _height, 1);
		Graphics g = tag.getGraphics();
		g.drawImage(img.getScaledInstance(_width, _height, 4), 0, 0, null);

		g.dispose();
		return tag;
	}

	/**
	 * @Description: 对BufferImage按照(x, y, width, height) = (subImageBounds.x,
	 *               subImageBounds.y, subImageBounds.width,
	 *               subImageBounds.height)进行裁剪
	 *               如果subImageBounds范围过大，则用空白填充周围区域。
	 * 
	 * @param image
	 * @param subImageBounds
	 * @param destImageFile
	 * @throws IOException
	 
	 */
	static void saveSubImage(BufferedImage image, Rectangle subImageBounds,
			File destImageFile) throws IOException {
		String fileName = destImageFile.getName();
		String formatName = fileName.substring(fileName.lastIndexOf('.') + 1);
		BufferedImage subImage = new BufferedImage(subImageBounds.width,
				subImageBounds.height, 1);
		Graphics g = subImage.createGraphics();

		if ((subImageBounds.width > image.getWidth())
				|| (subImageBounds.height > image.getHeight())) {
			int left = subImageBounds.x;
			int top = subImageBounds.y;
			if (image.getWidth() < subImageBounds.width)
				left = (subImageBounds.width - image.getWidth()) / 2;
			if (image.getHeight() < subImageBounds.height)
				top = (subImageBounds.height - image.getHeight()) / 2;
			g.setColor(Color.white);
			g.fillRect(0, 0, subImageBounds.width, subImageBounds.height);
			g.drawImage(image, left, top, null);
			ImageIO.write(image, formatName, destImageFile);
			 
			
		} else {
			g.drawImage(image.getSubimage(subImageBounds.x, subImageBounds.y,
					subImageBounds.width, subImageBounds.height), 0, 0, null);
		}
		g.dispose();
		ImageIO.write(subImage, formatName, destImageFile);
	
	}
	
	
	private void tif2jpeg(String inputFile,String outputFile){
		  
		//TODO 
 
	}
}
