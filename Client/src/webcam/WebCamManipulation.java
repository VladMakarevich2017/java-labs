package webcam;

import org.bytedeco.javacv.*;
import org.bytedeco.javacv.FrameGrabber.Exception;

import static org.bytedeco.javacpp.opencv_core.IplImage;

public class WebCamManipulation implements Runnable {
	private static IplImage currentImage;
	private static FrameGrabber grabber; 
	@Override
	public void run() {
		try {
			grabber = new OpenCVFrameGrabber("");
			OpenCVFrameConverter.ToIplImage converter = new OpenCVFrameConverter.ToIplImage();
			grabber.start();     
			Frame frame;
			while(true) {
				frame = grabber.grab();
				currentImage = converter.convert(frame);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void closeWebCam() throws Exception {
		grabber.close();
	}

	public static IplImage getCurrentImage() {
		return currentImage;
	}

	public static void setCurrentImage(IplImage currentImage) {
		WebCamManipulation.currentImage = currentImage;
	}
	
	public static FrameGrabber getGrabber() {
		return grabber;
	}

	public static void setGrabber(FrameGrabber grabber) {
		WebCamManipulation.grabber = grabber;
	}
}
