package webcam;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Base64;
import javax.imageio.ImageIO;
import org.bytedeco.javacpp.opencv_core.IplImage;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.Java2DFrameConverter;
import org.bytedeco.javacv.OpenCVFrameConverter;

public class ImageManipulation {
	
	public static String imageToString(IplImage image) {
		try {
			OpenCVFrameConverter.ToIplImage grabberConverter = new OpenCVFrameConverter.ToIplImage();
		    Java2DFrameConverter paintConverter = new Java2DFrameConverter();
		    Frame frame = grabberConverter.convert(image);
		    BufferedImage originalImage = paintConverter.getBufferedImage(frame,1);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write( originalImage, "jpg", baos );
			baos.flush();
			byte[] imageInByte = baos.toByteArray();
			baos.close();
			return encodeImage(imageInByte);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public static void stringToImage(String string, String filename) {
		System.out.println(filename);
		OutputStream outputStream = null;
        byte [] imageInByteArray = decodeImage(string);
        try {
            outputStream = new FileOutputStream(filename);
            outputStream.write(imageInByteArray);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
	}
	
	public static void savingResizingImage(BufferedImage image, int width, int height, String fileName) throws IOException {
		try {
			File outputfile = new File(fileName);
			ImageIO.write(createResizedCopy(image, width, height, true), "jpg", outputfile);
		} catch(FileNotFoundException e) {
		} catch(NullPointerException e) {	
		}
	}
	
	public static BufferedImage stringToBufferedImage(String string) throws IOException {
		if(string == null) return null;
		InputStream in = new ByteArrayInputStream(decodeImage(string));
		return ImageIO.read(in);
	}

	public static String encodeImage(byte[] imageByteArray) {
		return Base64.getUrlEncoder().encodeToString(imageByteArray);
	}

	public static byte[] decodeImage(String imageDataString) {
		return Base64.getUrlDecoder().decode(imageDataString);
	}
	
	static BufferedImage createResizedCopy(Image originalImage, 
            int scaledWidth, int scaledHeight, 
            boolean preserveAlpha)
    {
        int imageType = preserveAlpha ? BufferedImage.TYPE_INT_RGB : BufferedImage.TYPE_INT_ARGB;
        BufferedImage scaledBI = new BufferedImage(scaledWidth, scaledHeight, imageType);
        Graphics2D g = scaledBI.createGraphics();
        if (preserveAlpha) {
            g.setComposite(AlphaComposite.Src);
        }
        g.drawImage(originalImage, 0, 0, scaledWidth, scaledHeight, null); 
        g.dispose();
        return scaledBI;
    }
	
	
	public static BufferedImage IplImageToBufferedImage(IplImage src) {
	    OpenCVFrameConverter.ToIplImage grabberConverter = new OpenCVFrameConverter.ToIplImage();
	    Java2DFrameConverter paintConverter = new Java2DFrameConverter();
	    Frame frame = grabberConverter.convert(src);
	    return paintConverter.getBufferedImage(frame,1);
	}
}
