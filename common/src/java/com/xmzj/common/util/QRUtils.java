/**
 * 
 */
package com.xmzj.common.util;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

/**
 * 二维码 工具类
 * 
 * @author WinMoney 2016年4月28日 下午2:34:00
 * 
 */
public class QRUtils {
	
	public static String png = "png";
	static final Logger log = Logger.getRootLogger();
	
	public static BufferedImage createQRCodeImg(String content) {
		int width = 230; // 图像宽度
		int height = 230; // 图像高度
		Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
		hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
		BufferedImage qrCode = null;// 生成矩阵
		try {
			BitMatrix bitMatrix = new MultiFormatWriter().encode(content,BarcodeFormat.QR_CODE, width, height, hints);
			qrCode = QRUtils.toBufferedImage(bitMatrix);
			/*Graphics2D g = qrCode.createGraphics(); 
			 //读取Logo图片
			 BufferedImage logo = ImageIO.read(new File(SysConfig.getDiskbasepath()+SysConfig.getDaddylogo()));
			 int widthLogo = logo.getWidth(), heightLogo = logo.getHeight();
			 // 计算图片放置位置
			 int x = (qrCode.getWidth() - widthLogo) / 2;
			 int y = (qrCode.getHeight() - logo.getHeight()) / 2;
			 //开始绘制图片
			 g.drawImage(logo, x, y, widthLogo, heightLogo, null);
			 g.drawRoundRect(x, y, widthLogo, heightLogo, 15, 15);
			 g.setColor(Color.WHITE);
			 g.drawRect(x, y, widthLogo, heightLogo);
			 g.dispose();
			 logo.flush();*/
		} catch (WriterException e) {
			e.printStackTrace();
		}
		return qrCode;
	}

	/**
	 * 获取BufferedImage
	 * @author WinMoney 2016年4月28日 下午3:57:13
	 * @param matrix
	 * @return
	 */
	public static BufferedImage toBufferedImage(BitMatrix matrix) {
		int width = matrix.getWidth();
		int height = matrix.getHeight();
		BufferedImage image = new BufferedImage(width, height, 2);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				image.setRGB(x, y, matrix.get(x, y) ? -16777216 : -1);
			}
		}
		return image;
	}
	
	public static void outQRCodeImg(String content,OutputStream outStream){
		try {
			BufferedImage qrCode =  createQRCodeImg(content);
		    ImageIO.write(qrCode,png, outStream);
			outStream.close();
		} catch (IOException e) {
			log.error("输出二维码出错！");
		}
	}

}
