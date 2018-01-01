package cn.fuqiang.food.utilities;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * @author adam.������
 * �������� 2012-2-29
 */
public class ImageTools{

    public ImageTools() {
  super();
 }

 /** 
  * ��ͼƬ�ü������Ѳü���ͼƬ���� 
  * @param srcPath ��ȡԴͼƬ·��
  * @param toPath д��ͼƬ·��
  * @param x ������ʼ��x����
  * @param y ������ʼ��y����
  * @param width ���п��
  * @param height  ���и߶�
  * @param readImageFormat  ��ȡͼƬ��ʽ
  * @param writeImageFormat д��ͼƬ��ʽ
  * @throws IOException
  */
    public void cropImage(String srcPath,String toPath,
      int x,int y,int width,int height,
      String readImageFormat,String writeImageFormat) throws IOException{   
        FileInputStream fis = null ;
        ImageInputStream iis =null ;
        try{   
            //��ȡͼƬ�ļ�
         fis = new FileInputStream(srcPath); 
            Iterator it = ImageIO.getImageReadersByFormatName(readImageFormat); 
            ImageReader reader = (ImageReader) it.next(); 
            //��ȡͼƬ�� 
            iis = ImageIO.createImageInputStream(fis);  
            reader.setInput(iis,true) ;
            ImageReadParam param = reader.getDefaultReadParam(); 
            //����һ������
            Rectangle rect = new Rectangle(x, y, width, height); 
            //�ṩһ�� BufferedImage���������������������ݵ�Ŀ�ꡣ 
            param.setSourceRegion(rect);
            BufferedImage bi = reader.read(0,param);                
            //������ͼƬ 
            ImageIO.write(bi, writeImageFormat, new File(toPath));     
        }finally{
            if(fis!=null)
             fis.close();       
            if(iis!=null)
               iis.close(); 
        } 
    }

    /**
     * ��������СͼƬ
     * @param srcImagePath ��ȡͼƬ·��
     * @param toImagePath д��ͼƬ·��
     * @param widthRatio �����С����
     * @param heightRatio  �߶���С����
     * @throws IOException
     */
    public void reduceImageByRatio(String srcImagePath,String toImagePath,int widthRatio,int heightRatio) throws IOException{
     FileOutputStream out = null;
     try{
      //�����ļ�  
            File file = new File(srcImagePath);  
            // ����Image����  
            BufferedImage src = javax.imageio.ImageIO.read(file);  
            int width = src.getWidth();  
            int height = src.getHeight();  
            // ��С�߳� 
            BufferedImage tag = new BufferedImage(width / widthRatio, height / heightRatio, BufferedImage.TYPE_INT_RGB);  
            // ���� ��С  ���ͼƬ 
            tag.getGraphics().drawImage(src, 0, 0, width / widthRatio, height / heightRatio, null);  
            out = new FileOutputStream(toImagePath);  
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);  
            encoder.encode(tag);  
     }catch(Exception e){
      e.printStackTrace();
     }finally{
      if(out != null){
                out.close();  
      }
     }
    }

    /**
     * ���ߵȱ�����СͼƬ
     * @param srcImagePath ��ȡͼƬ·��
     * @param toImagePath д��ͼƬ·��
     * @param ratio ��С����
     * @throws IOException
     */
    public void reduceImageEqualProportion(String srcImagePath,String toImagePath,int ratio) throws IOException{
     FileOutputStream out = null;
     try{
      //�����ļ�  
            File file = new File(srcImagePath);  
            // ����Image����  
            BufferedImage src = javax.imageio.ImageIO.read(file);  
            int width = src.getWidth();  
            int height = src.getHeight();  
            // ��С�߳� 
            BufferedImage tag = new BufferedImage(width / ratio, height / ratio, BufferedImage.TYPE_INT_RGB);  
            // ���� ��С  ���ͼƬ 
            tag.getGraphics().drawImage(src, 0, 0, width / ratio, height / ratio, null);  
            out = new FileOutputStream(toImagePath);  
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);  
            encoder.encode(tag);  
     }catch(Exception e){
      e.printStackTrace();
     }finally{
      if(out != null){
                out.close();  
      }
     }
    }
    
    /**
     * �����ʷŴ�ͼƬ
     * @param srcImagePath ��ȡͼ��·��
     * @param toImagePath д������·��
     * @param widthRatio ��ȷŴ����
     * @param heightRatio �߶ȷŴ����
     * @throws IOException
     */
    public void enlargementImageByRatio(String srcImagePath,String toImagePath,int widthRatio,int heightRatio) throws IOException{
     FileOutputStream out = null;
     try{
      //�����ļ�  
            File file = new File(srcImagePath);  
            // ����Image����  
            BufferedImage src = javax.imageio.ImageIO.read(file);  
            int width = src.getWidth();  
            int height = src.getHeight();  
            // �Ŵ�߳�
            BufferedImage tag = new BufferedImage(width * widthRatio, height * heightRatio, BufferedImage.TYPE_INT_RGB);  
            //���ƷŴ���ͼƬ
            tag.getGraphics().drawImage(src, 0, 0, width * widthRatio, height * heightRatio, null);  
            out = new FileOutputStream(toImagePath);  
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);  
            encoder.encode(tag);  
     }catch(Exception e){
      e.printStackTrace();
     }finally{
      if(out != null){
                out.close();  
      }
     }
    }
    
    
    /**
     * ���ߵȱ����Ŵ�ͼƬ
     * @param srcImagePath ��ȡͼ��·��
     * @param toImagePath д������·��
     * @param ratio �Ŵ����
     * @throws IOException
     */
    public void enlargementImageEqualProportion(String srcImagePath,String toImagePath,int ratio) throws IOException{
     FileOutputStream out = null;
     try{
      //�����ļ�  
            File file = new File(srcImagePath);  
            // ����Image����  
            BufferedImage src = javax.imageio.ImageIO.read(file);  
            int width = src.getWidth();  
            int height = src.getHeight();  
            // �Ŵ�߳�
            BufferedImage tag = new BufferedImage(width * ratio, height * ratio, BufferedImage.TYPE_INT_RGB);  
            //���ƷŴ���ͼƬ
            tag.getGraphics().drawImage(src, 0, 0, width * ratio, height * ratio, null);  
            out = new FileOutputStream(toImagePath);  
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);  
            encoder.encode(tag);  
     }catch(Exception e){
      e.printStackTrace();
     }finally{
      if(out != null){
                out.close();  
      }
     }
    }
    
    /**
     * ����ͼ�εı߳���С
     * @param srcImagePath 
     * @param toImagePath
     * @param width
     * @param height
     * @throws IOException
     */
    public void resizeImage(String srcImagePath,String toImagePath,int width,int height) throws IOException{
     FileOutputStream out = null;
     try{
      //�����ļ�  
            File file = new File(srcImagePath);  
            // ����Image����  
            BufferedImage src = javax.imageio.ImageIO.read(file);  
            // �Ŵ�߳�
            BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);  
            //���ƷŴ���ͼƬ
            tag.getGraphics().drawImage(src, 0, 0, width, height, null);  
            out = new FileOutputStream(toImagePath);  
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);  
            encoder.encode(tag);  
     }catch(Exception e){
      e.printStackTrace();
     }finally{
      if(out != null){
                out.close();  
      }
     }
    }
    
    /**
     * ����ƴ��ͼƬ�����ţ�
     * @param firstSrcImagePath ��һ��ͼƬ��·��
     * @param secondSrcImagePath �ڶ���ͼƬ��·��
     * @param imageFormat ƴ������ͼƬ�ĸ�ʽ
     * @param toPath ƴ������ͼƬ��·��
     */
    public void joinImagesHorizontal(String firstSrcImagePath, String secondSrcImagePath,String imageFormat, String toPath){  
     try {  
      //��ȡ��һ��ͼƬ    
      File  fileOne  =  new  File(firstSrcImagePath);    
            BufferedImage  imageOne = ImageIO.read(fileOne);    
            int  width  =  imageOne.getWidth();//ͼƬ���    
            int  height  =  imageOne.getHeight();//ͼƬ�߶�    
            //��ͼƬ�ж�ȡRGB    
            int[]  imageArrayOne  =  new  int[width*height];    
            imageArrayOne  =  imageOne.getRGB(0,0,width,height,imageArrayOne,0,width);    
           
            //�Եڶ���ͼƬ����ͬ�Ĵ���    
            File  fileTwo  =  new  File(secondSrcImagePath);    
            BufferedImage  imageTwo  =  ImageIO.read(fileTwo); 
            int width2 = imageTwo.getWidth();
            int height2 = imageTwo.getHeight();
            int[]   ImageArrayTwo  =  new  int[width2*height2];    
            ImageArrayTwo  =  imageTwo.getRGB(0,0,width,height,ImageArrayTwo,0,width);    
            //ImageArrayTwo  =  imageTwo.getRGB(0,0,width2,height2,ImageArrayTwo,0,width2); 
           
            //������ͼƬ
            //int height3 = (height>height2 || height==height2)?height:height2;
            BufferedImage  imageNew  =  new  BufferedImage(width*2,height,BufferedImage.TYPE_INT_RGB);    
            //BufferedImage  imageNew  =  new  BufferedImage(width+width2,height3,BufferedImage.TYPE_INT_RGB);    
            imageNew.setRGB(0,0,width,height,imageArrayOne,0,width);//������벿�ֵ�RGB  
            imageNew.setRGB(width,0,width,height,ImageArrayTwo,0,width);//�����Ұ벿�ֵ�RGB 
            //imageNew.setRGB(width,0,width2,height2,ImageArrayTwo,0,width2);//�����Ұ벿�ֵ�RGB    
           
            File  outFile  =  new  File(toPath);    
            ImageIO.write(imageNew,  imageFormat,  outFile);//дͼƬ
        } catch (Exception e) {  
         e.printStackTrace();  
        }  
    }
    
    /**
  * ����ƴ��һ�飨���ţ�ͼ��
  * @param pics  ��Ҫƴ�ӵ�ͼ��
  * @param type ͼ��д���ʽ
  * @param dst_pic ͼ��д��·��
  * @return
  */
    public  boolean joinImageListHorizontal(String[] pics, String type, String dst_pic) {   
     try {  
      int len = pics.length;  
      if (len < 1) {  
       System.out.println("pics len < 1");  
                return false;  
            }  
      File[] src = new File[len];  
      BufferedImage[] images = new BufferedImage[len];  
      int[][] imageArrays = new int[len][];  
      for (int i = 0; i < len; i++) {  
       src[i] = new File(pics[i]);  
       images[i] = ImageIO.read(src[i]);  
       int width = images[i].getWidth();  
       int height = images[i].getHeight();  
       imageArrays[i] = new int[width * height];// ��ͼƬ�ж�ȡRGB    
       imageArrays[i] = images[i].getRGB(0, 0, width, height,  imageArrays[i], 0, width);  
      }  
      
      int dst_width = 0;  
      int dst_height = images[0].getHeight();  
      for (int i = 0; i < images.length; i++) {  
       dst_height = dst_height > images[i].getHeight() ? dst_height : images[i].getHeight();  
       dst_width += images[i].getWidth();
      }  
      //System.out.println(dst_width);  
      //System.out.println(dst_height);  
      if (dst_height < 1) {  
       System.out.println("dst_height < 1");  
       return false;  
      } 
      /*
       * ������ͼƬ
       */   
      BufferedImage ImageNew = new BufferedImage(dst_width, dst_height,  BufferedImage.TYPE_INT_RGB);  
      int width_i = 0;
      for (int i = 0; i < images.length; i++) {  
       ImageNew.setRGB(width_i, 0, images[i].getWidth(), dst_height,  imageArrays[i], 0, images[i].getWidth());  
       width_i += images[i].getWidth();
      }  
      File outFile = new File(dst_pic);  
      ImageIO.write(ImageNew, type, outFile);// дͼƬ   
     } catch (Exception e) {  
            e.printStackTrace();  
            return false;  
        }  
        return true;  
    }
    
    /**
     * ����ƴ��ͼƬ�����ţ�
     * @param firstSrcImagePath ��ȡ�ĵ�һ��ͼƬ
     * @param secondSrcImagePath ��ȡ�ĵڶ���ͼƬ
     * @param imageFormat ͼƬд���ʽ
     * @param toPath ͼƬд��·��
     */
    public void joinImagesVertical(String firstSrcImagePath, String secondSrcImagePath,String imageFormat, String toPath){  
        try {  
         //��ȡ��һ��ͼƬ    
            File  fileOne  =  new  File(firstSrcImagePath);    
            BufferedImage  imageOne = ImageIO.read(fileOne);    
            int  width  =  imageOne.getWidth();//ͼƬ���    
            int  height  =  imageOne.getHeight();//ͼƬ�߶�    
            //��ͼƬ�ж�ȡRGB    
            int[]  imageArrayOne  =  new  int[width*height];    
            imageArrayOne  =  imageOne.getRGB(0,0,width,height,imageArrayOne,0,width);    
       
            //�Եڶ���ͼƬ����ͬ�Ĵ���    
            File  fileTwo  =  new  File(secondSrcImagePath);    
            BufferedImage  imageTwo  =  ImageIO.read(fileTwo); 
            int width2 = imageTwo.getWidth();
            int height2 = imageTwo.getHeight();
            int[]   ImageArrayTwo  =  new  int[width2*height2];    
            ImageArrayTwo  =  imageTwo.getRGB(0,0,width,height,ImageArrayTwo,0,width);    
            //ImageArrayTwo  =  imageTwo.getRGB(0,0,width2,height2,ImageArrayTwo,0,width2); 
       
            //������ͼƬ
            //int width3 = (width>width2 || width==width2)?width:width2;
            BufferedImage  imageNew  =  new  BufferedImage(width,height*2,BufferedImage.TYPE_INT_RGB);    
            //BufferedImage  imageNew  =  new  BufferedImage(width3,height+height2,BufferedImage.TYPE_INT_RGB);    
            imageNew.setRGB(0,0,width,height,imageArrayOne,0,width);//�����ϰ벿�ֵ�RGB    
            imageNew.setRGB(0,height,width,height,ImageArrayTwo,0,width);//�����°벿�ֵ�RGB
            //imageNew.setRGB(0,height,width2,height2,ImageArrayTwo,0,width2);//�����°벿�ֵ�RGB    
       
            File  outFile  =  new  File(toPath);    
            ImageIO.write(imageNew,  imageFormat,  outFile);//дͼƬ
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }
    
    /**
     * ����ƴ��һ�飨���ţ�ͼ��
     * @param pics  ��Ҫƴ�ӵ�ͼ������
     * @param type д��ͼ������
     * @param dst_pic д��ͼ��·��
     * @return
     */
 public  boolean joinImageListVertical(String[] pics, String type, String dst_pic) {   
        try {  
         int len = pics.length;  
            if (len < 1) {  
                System.out.println("pics len < 1");  
                return false;  
            }  
          File[] src = new File[len];  
             BufferedImage[] images = new BufferedImage[len];  
             int[][] imageArrays = new int[len][];  
             for (int i = 0; i < len; i++) {  
             //System.out.println(i);
             src[i] = new File(pics[i]);  
             images[i] = ImageIO.read(src[i]);  
             int width = images[i].getWidth();  
             int height = images[i].getHeight();  
             imageArrays[i] = new int[width * height];// ��ͼƬ�ж�ȡRGB   
             imageArrays[i] = images[i].getRGB(0, 0, width, height,  imageArrays[i], 0, width);  
         }  
             
         int dst_height = 0;  
         int dst_width = images[0].getWidth();  
         for (int i = 0; i < images.length; i++) {  
             dst_width = dst_width > images[i].getWidth() ? dst_width : images[i].getWidth();  
             dst_height += images[i].getHeight();  
         }  
         //System.out.println(dst_width);  
         //System.out.println(dst_height);  
         if (dst_height < 1) {  
             System.out.println("dst_height < 1");  
             return false;  
         }  
         /*
          * ������ͼƬ
          */   
            BufferedImage ImageNew = new BufferedImage(dst_width, dst_height,  BufferedImage.TYPE_INT_RGB);  
            int height_i = 0;  
            for (int i = 0; i < images.length; i++) {  
                ImageNew.setRGB(0, height_i, dst_width, images[i].getHeight(),  imageArrays[i], 0, dst_width);  
                height_i += images[i].getHeight();  
            }  
            File outFile = new File(dst_pic);  
            ImageIO.write(ImageNew, type, outFile);// дͼƬ   
        } catch (Exception e) {  
            e.printStackTrace();  
            return false;  
        }  
        return true;  
    }  
    
    /**
     * �ϲ�ͼƬ(��ָ����ʼx��y���꽫����ͼƬ������ͼ֮��)
     * @param negativeImagePath ����ͼƬ·��
     * @param additionImagePath ����ͼƬ·��
     * @param x ����ͼƬ����ʼ��x����
     * @param y  ����ͼƬ����ʼ��y����
     * @param toPath ͼƬд��·��
     * @throws IOException
     */
    public void mergeBothImage(String negativeImagePath,String additionImagePath,int x,int y,String toPath ) throws IOException{
     InputStream is= null;
     InputStream is2= null;
     OutputStream os = null;
     try{
      is=new FileInputStream(negativeImagePath);
            is2=new FileInputStream(additionImagePath);
            BufferedImage image=ImageIO.read(is);
            BufferedImage image2=ImageIO.read(is2);
            Graphics g=image.getGraphics();
            g.drawImage(image2,x,y,null);
            os = new FileOutputStream(toPath);
            JPEGImageEncoder enc=JPEGCodec.createJPEGEncoder(os);
            enc.encode(image);
     }catch(Exception e){
      e.printStackTrace();
     }finally{
      if(os != null){
       os.close();
      }
      if(is2 != null){
       is2.close();
      }
      if(is != null){
       is.close();
      }
     }
    }
    
    /** 
     * ��һ��ͼƬһ���Ը��Ӻϲ�����ͼ��
     * @param negativeImagePath  Դͼ�񣨵�ͼ��·��
     * @param additionImageList ����ͼ����Ϣ�б�
     * @param imageFormat ͼ��д���ʽ
     * @param toPath ͼ��д��·��
     * @throws IOException
     */
    public void mergeImageList(String negativeImagePath,List additionImageList,String imageFormat, String toPath) throws IOException{
     InputStream is= null;
     InputStream is2= null;
     OutputStream os = null;
     try{
      is=new FileInputStream(negativeImagePath);
      BufferedImage image=ImageIO.read(is);
      //Graphics g=image.getGraphics();
      Graphics2D g = image.createGraphics();;
      BufferedImage image2 = null;
      if(additionImageList != null){
       for(int i=0;i<additionImageList.size();i++){
        //��������ͼƬ��Ϣ��x���ꡢ y���ꡢ additionImagePath����ͼƬ·��
        //ͼƬ��Ϣ�洢��һ��������
        String[] additionImageInfo = (String[]) additionImageList.get(i);
        int x = Integer.parseInt(additionImageInfo[0]);
        int y = Integer.parseInt(additionImageInfo[1]);
        String additionImagePath = additionImageInfo[2];
        //��ȡ�ļ������������ϲ�ͼƬ
        is2 = new FileInputStream(additionImagePath);
        //System.out.println(x+"  :  "+y+"  :  "+additionImagePath);
        image2 = ImageIO.read(is2);
                 g.drawImage(image2,x,y,null);
       }
      }
            os = new FileOutputStream(toPath);
            ImageIO.write(image,  imageFormat,  os);//дͼƬ
            //JPEGImageEncoder enc=JPEGCodec.createJPEGEncoder(os);
            //enc.encode(image);
     }catch(Exception e){
      e.printStackTrace();
     }finally{
      if(os != null){
       os.close();
      }
      if(is2 != null){
       is2.close();
      }
      if(is != null){
       is.close();
      }
     }
    }
    
    /**
     * ������ͼƬ�ϲ�����ͼ�����Ͻ�
     * @param negativeImagePath ��ͼ·��
     * @param additionImagePath ����ͼƬ·��
     * @param toPath �ϳ�ͼƬд��·��
     * @throws IOException
     */
    public void mergeBothImageTopleftcorner(String negativeImagePath,String additionImagePath,String toPath ) throws IOException{
     InputStream is= null;
     InputStream is2= null;
     OutputStream os = null;
     try{
      is=new FileInputStream(negativeImagePath);
            is2=new FileInputStream(additionImagePath);
            BufferedImage image=ImageIO.read(is);
            BufferedImage image2=ImageIO.read(is2);
            Graphics g=image.getGraphics();
            g.drawImage(image2,0,0,null);
            os = new FileOutputStream(toPath);
            JPEGImageEncoder enc=JPEGCodec.createJPEGEncoder(os);
            enc.encode(image);
     }catch(Exception e){
      e.printStackTrace();
     }finally{
      if(os != null){
       os.close();
      }
      if(is2 != null){
       is2.close();
      }
      if(is != null){
       is.close();
      }
     }
    }
    
    /**
     * ������ͼƬ�ϲ�����ͼ�����Ͻ�
     * @param negativeImagePath ��ͼ·��
     * @param additionImagePath ����ͼƬ·��
     * @param toPath �ϳ�ͼƬд��·��
     * @throws IOException
     */
    public void mergeBothImageToprightcorner(String negativeImagePath,String additionImagePath,String toPath ) throws IOException{
     InputStream is= null;
     InputStream is2= null;
     OutputStream os = null;
     try{
      is=new FileInputStream(negativeImagePath);
            is2=new FileInputStream(additionImagePath);
            BufferedImage image=ImageIO.read(is);
            BufferedImage image2=ImageIO.read(is2);
            Graphics g=image.getGraphics();
            g.drawImage(image2,image.getWidth()-image2.getWidth(),0,null);
            os = new FileOutputStream(toPath);
            JPEGImageEncoder enc=JPEGCodec.createJPEGEncoder(os);
            enc.encode(image);
     }catch(Exception e){
      e.printStackTrace();
     }finally{
      if(os != null){
       os.close();
      }
      if(is2 != null){
       is2.close();
      }
      if(is != null){
       is.close();
      }
     }
    }
    
    /**
     * ������ͼƬ�ϲ�����ͼ�����½�
     * @param negativeImagePath ��ͼ·��
     * @param additionImagePath ����ͼƬ·��
     * @param toPath �ϳ�ͼƬд��·��
     * @throws IOException
     */
    public void mergeBothImageLeftbottom(String negativeImagePath,String additionImagePath,String toPath ) throws IOException{
     InputStream is= null;
     InputStream is2= null;
     OutputStream os = null;
     try{
      is=new FileInputStream(negativeImagePath);
            is2=new FileInputStream(additionImagePath);
            BufferedImage image=ImageIO.read(is);
            BufferedImage image2=ImageIO.read(is2);
            Graphics g=image.getGraphics();
            g.drawImage(image2,0,image.getHeight()-image2.getHeight(),null);
            os = new FileOutputStream(toPath);
            JPEGImageEncoder enc=JPEGCodec.createJPEGEncoder(os);
            enc.encode(image);
     }catch(Exception e){
      e.printStackTrace();
     }finally{
      if(os != null){
       os.close();
      }
      if(is2 != null){
       is2.close();
      }
      if(is != null){
       is.close();
      }
     }
    }
    
    /**
     * ������ͼƬ�ϲ�����ͼ�����½�
     * @param negativeImagePath ��ͼ·��
     * @param additionImagePath ����ͼƬ·��
     * @param toPath �ϳ�ͼƬд��·��
     * @throws IOException
     */
    public void mergeBothImageRightbottom(String negativeImagePath,String additionImagePath,String toPath ) throws IOException{
     InputStream is= null;
     InputStream is2= null;
     OutputStream os = null;
     try{
      is=new FileInputStream(negativeImagePath);
            is2=new FileInputStream(additionImagePath);
            BufferedImage image=ImageIO.read(is);
            BufferedImage image2=ImageIO.read(is2);
            Graphics g=image.getGraphics();
            g.drawImage(image2,image.getWidth()-image2.getWidth(),image.getHeight()-image2.getHeight(),null);
            os = new FileOutputStream(toPath);
            JPEGImageEncoder enc=JPEGCodec.createJPEGEncoder(os);
            enc.encode(image);
     }catch(Exception e){
      e.printStackTrace();
     }finally{
      if(os != null){
       os.close();
      }
      if(is2 != null){
       is2.close();
      }
      if(is != null){
       is.close();
      }
     }
    }
    
    /**
     * ������ͼƬ�ϲ�����ͼ��������
     * @param negativeImagePath ��ͼ·��
     * @param additionImagePath ����ͼƬ·��
     * @param toPath �ϳ�ͼƬд��·��
     * @throws IOException
     */
    public void mergeBothImageCenter(String negativeImagePath,String additionImagePath,String toPath ) throws IOException{
     InputStream is= null;
     InputStream is2= null;
     OutputStream os = null;
     try{
      is=new FileInputStream(negativeImagePath);
            is2=new FileInputStream(additionImagePath);
            BufferedImage image=ImageIO.read(is);
            BufferedImage image2=ImageIO.read(is2);
            Graphics g=image.getGraphics();
            g.drawImage(image2,image.getWidth()/2-image2.getWidth()/2,image.getHeight()/2-image2.getHeight()/2,null);
            os = new FileOutputStream(toPath);
            JPEGImageEncoder enc=JPEGCodec.createJPEGEncoder(os);
            enc.encode(image);
     }catch(Exception e){
      e.printStackTrace();
     }finally{
      if(os != null){
       os.close();
      }
      if(is2 != null){
       is2.close();
      }
      if(is != null){
       is.close();
      }
     }
    }
    
    /**
     * ������ͼƬ�ϲ�����ͼ���ϱ�����
     * @param negativeImagePath ��ͼ·��
     * @param additionImagePath ����ͼƬ·��
     * @param toPath �ϳ�ͼƬд��·��
     * @throws IOException
     */
    public void mergeBothImageTopcenter(String negativeImagePath,String additionImagePath,String toPath ) throws IOException{
     InputStream is= null;
     InputStream is2= null;
     OutputStream os = null;
     try{
      is=new FileInputStream(negativeImagePath);
            is2=new FileInputStream(additionImagePath);
            BufferedImage image=ImageIO.read(is);
            BufferedImage image2=ImageIO.read(is2);
            Graphics g=image.getGraphics();
            g.drawImage(image2,image.getWidth()/2-image2.getWidth()/2,0,null);
            os = new FileOutputStream(toPath);
            JPEGImageEncoder enc=JPEGCodec.createJPEGEncoder(os);
            enc.encode(image);
     }catch(Exception e){
      e.printStackTrace();
     }finally{
      if(os != null){
       os.close();
      }
      if(is2 != null){
       is2.close();
      }
      if(is != null){
       is.close();
      }
     }
    }
    
    /**
     * ������ͼƬ�ϲ�����ͼ���±�����
     * @param negativeImagePath ��ͼ·��
     * @param additionImagePath ����ͼƬ·��
     * @param toPath �ϳ�ͼƬд��·��
     * @throws IOException
     */
    public void mergeBothImageBottomcenter(String negativeImagePath,String additionImagePath,String toPath ) throws IOException{
     InputStream is= null;
     InputStream is2= null;
     OutputStream os = null;
     try{
      is=new FileInputStream(negativeImagePath);
            is2=new FileInputStream(additionImagePath);
            BufferedImage image=ImageIO.read(is);
            BufferedImage image2=ImageIO.read(is2);
            Graphics g=image.getGraphics();
            g.drawImage(image2,image.getWidth()/2-image2.getWidth()/2,image.getHeight()-image2.getHeight(),null);
            os = new FileOutputStream(toPath);
            JPEGImageEncoder enc=JPEGCodec.createJPEGEncoder(os);
            enc.encode(image);
     }catch(Exception e){
      e.printStackTrace();
     }finally{
      if(os != null){
       os.close();
      }
      if(is2 != null){
       is2.close();
      }
      if(is != null){
       is.close();
      }
     }
    }
    
    /**
     * ������ͼƬ�ϲ�����ͼ���������
     * @param negativeImagePath ��ͼ·��
     * @param additionImagePath ����ͼƬ·��
     * @param toPath �ϳ�ͼƬд��·��
     * @throws IOException
     */
    public void mergeBothImageLeftcenter(String negativeImagePath,String additionImagePath,String toPath ) throws IOException{
     InputStream is= null;
     InputStream is2= null;
     OutputStream os = null;
     try{
      is=new FileInputStream(negativeImagePath);
            is2=new FileInputStream(additionImagePath);
            BufferedImage image=ImageIO.read(is);
            BufferedImage image2=ImageIO.read(is2);
            Graphics g=image.getGraphics();
            g.drawImage(image2,0,image.getHeight()/2-image2.getHeight()/2,null);
            os = new FileOutputStream(toPath);
            JPEGImageEncoder enc=JPEGCodec.createJPEGEncoder(os);
            enc.encode(image);
     }catch(Exception e){
      e.printStackTrace();
     }finally{
      if(os != null){
       os.close();
      }
      if(is2 != null){
       is2.close();
      }
      if(is != null){
       is.close();
      }
     }
    }
    
    /**
     * ������ͼƬ�ϲ�����ͼ���ұ�����
     * @param negativeImagePath ��ͼ·��
     * @param additionImagePath ����ͼƬ·��
     * @param toPath �ϳ�ͼƬд��·��
     * @throws IOException
     */
    public void mergeBothImageRightcenter(String negativeImagePath,String additionImagePath,String toPath ) throws IOException{
     InputStream is= null;
     InputStream is2= null;
     OutputStream os = null;
     try{
      is=new FileInputStream(negativeImagePath);
            is2=new FileInputStream(additionImagePath);
            BufferedImage image=ImageIO.read(is);
            BufferedImage image2=ImageIO.read(is2);
            Graphics g=image.getGraphics();
            g.drawImage(image2,image.getWidth()-image2.getWidth(),image.getHeight()/2-image2.getHeight()/2,null);
            os = new FileOutputStream(toPath);
            JPEGImageEncoder enc=JPEGCodec.createJPEGEncoder(os);
            enc.encode(image);
     }catch(Exception e){
      e.printStackTrace();
     }finally{
      if(os != null){
       os.close();
      }
      if(is2 != null){
       is2.close();
      }
      if(is != null){
       is.close();
      }
     }
    }
    
    /**
     * ͼƬ�һ�����
     * @param srcImage ��ȡͼƬ·��
     * @param toPath д��һ����ͼƬ·��
     * @param imageFormat ͼƬд���ʽ
     */ 
    public void grayImage(String srcImage,String toPath,String imageFormat){
     try{
      BufferedImage src = ImageIO.read(new File(srcImage));
         ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_GRAY);
         ColorConvertOp op = new ColorConvertOp(cs, null);
         src = op.filter(src, null);
         ImageIO.write(src, imageFormat, new File(toPath));
     }catch(Exception e){
      e.printStackTrace();
     }
    }
    
    /**
     * ��ԴͼƬ������ˮӡ����
     * @param srcImagePath ԴͼƬ·��
     * @param alpha ͸���ȣ�0<alpha<1��
     * @param font ���壨���磺���壩
     * @param fontStyle  �����ʽ(���磺��ͨ��ʽ--Font.PLAIN������--Font.BOLD )
     * @param fontSize �����С
     * @param color ������ɫ(���磺��ɫ--Color.BLACK)
     * @param inputWords  ������ʾ��ͼƬ�ϵ�����
     * @param x  ������ʾ��ʼ��x����
     * @param y  ������ʾ��ʼ��y����
     * @param imageFormat д��ͼƬ��ʽ��png/jpg�ȣ�
     * @param toPath д��ͼƬ·��
     * @throws IOException 
     */
    public void alphaWords2Image(String srcImagePath,float alpha,
      String font,int fontStyle,int fontSize,Color color,
      String inputWords,int x,int y,String imageFormat,String toPath) throws IOException{
     FileOutputStream fos=null;
  try {
   BufferedImage image = ImageIO.read(new File(srcImagePath));
   //����java2D����
      Graphics2D g2d=image.createGraphics();
      //��Դͼ����䱳��
      g2d.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null, null);
      //����͸����
      AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
      g2d.setComposite(ac);
      //���������������ơ���ʽ����С
      g2d.setFont(new Font(font, fontStyle, fontSize));
      g2d.setColor(color);//����������ɫ
      g2d.drawString(inputWords, x, y); //����ˮӡ���ּ�����ʼx��y����
      g2d.dispose();
      fos=new FileOutputStream(toPath);
      ImageIO.write(image, imageFormat, fos);
     } catch (Exception e) {
        e.printStackTrace();
     }finally{
      if(fos!=null){
       fos.close();
      }
     }
    }
    
    /**
     * ��Դͼ��������ͼƬˮӡ  
     *  ---- ��alpha==1ʱ���ֲ�͸��������ͼƬ��ֱ����������Ч��һ����
     * @param srcImagePath ԴͼƬ·��
     * @param appendImagePath ˮӡͼƬ·��
     * @param alpha ͸����
     * @param x  ˮӡͼƬ����ʼx����
     * @param y  ˮӡͼƬ����ʼy����
     * @param width ˮӡͼƬ�Ŀ��
     * @param height  ˮӡͼƬ�ĸ߶�
     * @param imageFormat ͼ��д��ͼƬ��ʽ
     * @param toPath ͼ��д��·��
     * @throws IOException 
     */
    public void alphaImage2Image(String srcImagePath,String appendImagePath,
      float alpha,int x,int y,int width,int height,
      String imageFormat,String toPath) throws IOException{
     FileOutputStream fos = null;
     try {
   BufferedImage image = ImageIO.read(new File(srcImagePath));
   //����java2D����
      Graphics2D g2d=image.createGraphics();
      //��Դͼ����䱳��
      g2d.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null, null);
      //����͸����
      AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
      g2d.setComposite(ac);
      //����ˮӡͼƬ����ʼx/y���ꡢ��ȡ��߶�
      BufferedImage appendImage = ImageIO.read(new File(appendImagePath));
      g2d.drawImage(appendImage, x, y, width, height, null, null);
      g2d.dispose();
      fos=new FileOutputStream(toPath);
      ImageIO.write(image, imageFormat, fos);
     } catch (Exception e) {
        e.printStackTrace();
     }finally{
      if(fos!=null){
       fos.close();
      }
     }
    }
    
    /**
     * ������ ---- ʵ�����ǻ�һ�������ɫ��Բ
     * ---- ��ָ��������Ϊ���Ļ�һ��С�뾶��Բ�Σ����������ɫ���䵱��
     * @param srcImagePath  ԴͼƬ��ɫ
     * @param x  ���x����
     * @param y  ���y����
     * @param width ���Ŀ��
     * @param height ���ĸ߶�
     * @param ovalColor �����ɫ
     * @param imageFormat д��ͼƬ��ʽ
     * @param toPath д��·��
     * @throws IOException
     */
    public void drawPoint(String srcImagePath,int x,int y,int width,int height,Color ovalColor,String imageFormat,String toPath) throws IOException{
     FileOutputStream fos = null;
  try {
   //��ȡԴͼƬ
   BufferedImage image = ImageIO.read(new File(srcImagePath));
   //����xy���������������
   Graphics2D g2d = image.createGraphics();
   g2d.setColor(ovalColor);
   //���һ����Բ��
   g2d.fillOval(x, y, width, height);
   fos = new FileOutputStream(toPath);
   ImageIO.write(image, imageFormat, fos); 
  } catch (IOException e) {
   e.printStackTrace();
  }finally{
   if(fos!=null){
       fos.close();
      }
  }
    }
    
    /**
     * ��һ�飨�������---- ʵ�����ǻ�һ�飨����������ɫ��Բ
     * ---- ��ָ��������Ϊ���Ļ�һ��С�뾶��Բ�Σ����������ɫ���䵱��
     * @param srcImagePath ԭͼƬ·��
     * @param pointList ���б�
     * @param width ���
     * @param height  �߶�
     * @param ovalColor �����ɫ
     * @param imageFormat д��ͼƬ��ɫ
     * @param toPath д��·��
     * @throws IOException
     */
    public void drawPoints(String srcImagePath,List pointList,int width,int height,Color ovalColor,String imageFormat,String toPath) throws IOException{
     FileOutputStream fos = null;
  try {
   //��ȡԴͼƬ
   BufferedImage image = ImageIO.read(new File(srcImagePath));
   //����xy���������������
   Graphics2D g2d = image.createGraphics();
   g2d.setColor(ovalColor);
   //���һ����Բ��
   if(pointList != null){
    for(int i=0;i<pointList.size();i++){
     Point point = (Point)pointList.get(i);
     int x = (int) point.getX();
     int y = (int) point.getY();
     g2d.fillOval(x, y, width, height);
    }
   }
   fos = new FileOutputStream(toPath);
   ImageIO.write(image, imageFormat, fos); 
  } catch (IOException e) {
   e.printStackTrace();
  }finally{
   if(fos!=null){
       fos.close();
      }
  }
    }
    
    /**
     * ���߶�
     * @param srcImagePath ԴͼƬ·��
     * @param x1 ��һ����x����
     * @param y1 ��һ����y����
     * @param x2 �ڶ�����x����
     * @param y2 �ڶ�����y����
     * @param lineColor ������ɫ
     * @param toPath ͼ��д��·��
     * @param imageFormat ͼ��д���ʽ
     * @throws IOException 
     */
    public void drawLine(String srcImagePath,int x1,int y1,int x2,int y2, Color lineColor,String toPath,String imageFormat) throws IOException{
     FileOutputStream fos = null;
  try {
   //��ȡԴͼƬ
   BufferedImage image = ImageIO.read(new File(srcImagePath));
   //����xy���������������
   Graphics2D g2d = image.createGraphics();
   g2d.setColor(lineColor);
   g2d.drawLine( x1, y1, x2, y2);
   fos = new FileOutputStream(toPath);
   ImageIO.write(image, imageFormat, fos); 
  } catch (IOException e) {
   e.printStackTrace();
  }finally{
   if(fos!=null){
       fos.close();
      }
  }
    }
    
    /**
     * ������ / �߶�
     * ---- 2���㼴���߶Σ�����㻭����
     * @param srcImagePath ԴͼƬ·��
     * @param xPoints x��������
     * @param yPoints y��������
     * @param nPoints �������
     * @param lineColor ������ɫ
     * @param toPath ͼ��д��·��
     * @param imageFormat ͼƬд���ʽ
     * @throws IOException 
     */
    public void drawPolyline(String srcImagePath,int[] xPoints, int[] yPoints, int nPoints,Color lineColor,String toPath,String imageFormat) throws IOException{
     FileOutputStream fos = null;
  try {
   //��ȡԴͼƬ
   BufferedImage image = ImageIO.read(new File(srcImagePath));
   //����xy���������������
   Graphics2D g2d = image.createGraphics();
   //����������ɫ
   g2d.setColor(lineColor);
   g2d.drawPolyline(xPoints, yPoints, nPoints);
   //ͼ��д��·��
   fos = new FileOutputStream(toPath);
   ImageIO.write(image, imageFormat, fos); 
  } catch (IOException e) {
   e.printStackTrace();
  }finally{
   if(fos!=null){
       fos.close();
      }
  }
    }
    
    /**
     * �������ߣ���ͻ����ʾת�۵�
     * @param srcImagePath ԴͼƬ·��
     * @param xPoints x��������
     * @param yPoints y��������
     * @param nPoints �������
     * @param lineColor ������ɫ
     * @param width ��Ŀ��
     * @param height  ��ĸ߶�
     * @param ovalColor ��������ɫ
     * @param toPath ͼ��д��·��
     * @param imageFormat ͼ��д���ʽ
     * @throws IOException
     */
    public void drawPolylineShowPoints(String srcImagePath,int[] xPoints, int[] yPoints, int nPoints,Color lineColor,int width,int height,Color ovalColor,String toPath,String imageFormat) throws IOException{
     FileOutputStream fos = null;
  try {
   //��ȡԴͼƬ
   BufferedImage image = ImageIO.read(new File(srcImagePath));
   //����xy���������������
   Graphics2D g2d = image.createGraphics();
   //����������ɫ
   g2d.setColor(lineColor);
   //������
   g2d.drawPolyline(xPoints, yPoints, nPoints);
   //����Բ����ɫ
   g2d.setColor(ovalColor);
   //��Բ��
   if(xPoints != null){
    for(int i=0;i<xPoints.length;i++){
     int x = xPoints[i];
     int y = yPoints[i];
     g2d.fillOval(x, y, width, height);
    }
   }
   //ͼ��д��·��
   fos = new FileOutputStream(toPath);
   ImageIO.write(image, imageFormat, fos); 
  } catch (IOException e) {
   e.printStackTrace();
  }finally{
   if(fos!=null){
       fos.close();
      }
  }
    }
    
    
    /** 
     * ����һ���� x �� y �������鶨��ıպ϶����
     * @param srcImagePath ԴͼƬ·��
     * @param xPoints x��������
     * @param yPoints y��������
     * @param nPoints �����ĸ���
     * @param polygonColor ������ɫ
     * @param imageFormat ͼ��д���ʽ
     * @param toPath ͼ��д��·��
     * @throws IOException 
     */
    public void drawPolygon(String srcImagePath,int[] xPoints,int[] yPoints,int nPoints,Color polygonColor,String imageFormat,String toPath) throws IOException {
     FileOutputStream fos = null;
     try {
      //��ȡͼƬ
      BufferedImage image = ImageIO.read(new File(srcImagePath));
   //����xy��������Ʊպ϶����
   Graphics2D g2d = image.createGraphics();
   g2d.setColor(polygonColor);
   g2d.drawPolygon(xPoints, yPoints, nPoints);
   fos = new FileOutputStream(toPath);
   ImageIO.write(image, imageFormat, fos); 
   g2d.dispose();
  } catch (Exception e) {
   e.printStackTrace();
  }finally{
     if(fos!=null){
      fos.close();
     } 
   }
    }
    
    /**
     * ���Ʋ��������
     * @param srcImagePath Դͼ��·��
     * @param xPoints x��������
     * @param yPoints y��������
     * @param nPoints ��������
     * @param polygonColor ����������ɫ
     * @param alpha ����β���͸����
     * @param imageFormat д��ͼ�θ�ʽ
     * @param toPath д��ͼ��·��
     * @throws IOException
     */
    public void drawAndAlphaPolygon(String srcImagePath,int[] xPoints,int[] yPoints,int nPoints,Color polygonColor,float alpha,String imageFormat,String toPath) throws IOException{
     FileOutputStream fos = null;
     try {
      //��ȡͼƬ
      BufferedImage image = ImageIO.read(new File(srcImagePath));
   //����xy��������Ʊպ϶����
   Graphics2D g2d = image.createGraphics();
   g2d.setColor(polygonColor);
   //����͸����
      AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
      g2d.setComposite(ac);
   g2d.fillPolygon(xPoints, yPoints, nPoints);
   fos = new FileOutputStream(toPath);
   ImageIO.write(image, imageFormat, fos); 
   g2d.dispose();
  } catch (Exception e) {
   e.printStackTrace();
  }finally{
     if(fos!=null){
      fos.close();
     } 
   }
    }
    
    
    public static void main(String[] args)throws Exception{
        ImageTools imageObj = new ImageTools();
        
        /*String srcPath = "D:/test/fileSource/004.jpg";
     String toPath = "D:/test/desk/+e004.jpg";
     int x = 200;
     int y = 300;
     int width = 300;
     int height = 200 ;
     String readImageFormat = "jpg";
     String writeImageFormat = "jpg"*/;
        //imageObj.cropImage(srcPath, toPath, x, y, width, height,readImageFormat,writeImageFormat);//����ͼƬ
        //imageObj.resizeImage(srcPath, toPath, 400, 400);//��ָ���ĳ�������ͼ�δ�С
       //imageObj.reduceImageByRatio(srcPath, toPath, 3, 3);//��ָ�����Ϳ�ı�����Сͼ��
       //imageObj.enlargementImageByRatio(srcPath, toPath, 2, 2);//��ָ�����Ϳ�ı����Ŵ�ͼ��
       //imageObj.reduceImageEqualProportion(srcPath, toPath, 4);//���ߵȱ�����С
        //imageObj.enlargementImageEqualProportion(srcPath, toPath, 2);//���ߵȱ����Ŵ�
       /* String negativeImagePath = "D:/test/fileSource/004.jpg";
        String additionImagePath = "D:/test/fileSource/005.jpg";
        int x = 200;
        int y = 200;
        String toPath = "D:/test/desk/004+005-rightcenter.jpg";*/
        //imageObj.mergeBothImage(negativeImagePath, additionImagePath, x, y, toPath); //��ָ������ϲ�ͼƬ
        //imageObj.mergeBothImageTopleftcorner(negativeImagePath, additionImagePath, toPath);//�ϲ������Ͻ�
        //imageObj.mergeBothImageToprightcorner(negativeImagePath, additionImagePath, toPath);//�ϲ������Ͻ�
        //imageObj.mergeBothImageLeftbottom(negativeImagePath, additionImagePath, toPath);//�ϲ������½�
        //imageObj.mergeBothImageRightbottom(negativeImagePath, additionImagePath, toPath);//�ϲ������½�
        //imageObj.mergeBothImageCenter(negativeImagePath, additionImagePath, toPath);//�ϲ���������
        //imageObj.mergeBothImageTopcenter(negativeImagePath, additionImagePath, toPath);//�ϲ����ϱ�����
        //imageObj.mergeBothImageBottomcenter(negativeImagePath, additionImagePath, toPath);//�ϲ����±�����
        //imageObj.mergeBothImageLeftcenter(negativeImagePath, additionImagePath, toPath);//�ϲ����������
        //imageObj.mergeBothImageRightcenter(negativeImagePath, additionImagePath, toPath);//�ϲ����ұ�����
     
     /*
     String srcImage = "D:/test/fileSource/001.jpg";
     String toPath = "D:/test/desk/001-gray.jpg";
     String imageFormat = "jpg";
     imageObj.grayImage(srcImage, toPath, imageFormat);//ͼƬ�һ�
      */    
     
     /*
     String firstSrcImagePath = "D:/test/desk/003.jpg";
     String secondSrcImagePath = "D:/test/desk/004.jpg";
     String imageFormat = "jpg";
     String toPath = "D:/test/desk/003-004-join.jpg";
     imageObj.joinImagesHorizontal(firstSrcImagePath, secondSrcImagePath, imageFormat, toPath);//����ƴ��ͼƬ
     */
     
     /*
     String firstSrcImagePath = "D:/test/desk/001-002-join.jpg";
     String secondSrcImagePath = "D:/test/desk/003-004-join.jpg";
     String imageFormat = "jpg";
     String toPath = "D:/test/desk/all-join.jpg";
     imageObj.joinImagesVertical(firstSrcImagePath, secondSrcImagePath, imageFormat, toPath);//����ƴ��ͼƬ
     */
     
     /*String srcImagePath = "D:/test/fileSource/002.jpg";
     int[] xPoints = {20,100,160,270,500}; 
     int[] yPoints = {30,150,172,295,615};
     int nPoints = 5; 
     String toPath = "D:/test/desk/polygon-002.png";
     imageObj.drawPolygon(srcImagePath, xPoints, yPoints, nPoints, Color.MAGENTA, "jpg", toPath); //��������������ƶ����
     */

     /*String srcImagePath = "D:/test/fileSource/004.jpg";
     String appendImagePath = "D:/test/fileSource/005.jpg";
     float alpha = 0.2F;
     String  font = "����";
     int fontStyle = Font.PLAIN;
     int fontSize = 32;
     Color color = Color.RED;
     String inputWords = "ͼƬ������ˮӡ���� ---- ���� ��ͨ���� 32���� ��ɫ ͸����0.5";
     int x = 20;
     int y = 40;
     String imageFormat = "jpg";
     String toPath = "D:/test/desk/alphaI2I-001.png";*/
     //imageObj.alphaWords2Image(srcImagePath, alpha, font, fontStyle, fontSize, color, inputWords, x, y, imageFormat, toPath); //��������ˮӡ
     //imageObj.alphaImage2Image(srcImagePath, appendImagePath, alpha, x, y, 300, 200, imageFormat, toPath);//����ͼƬˮӡ
     
     /*
     String srcImagePath = "D:/test/fileSource/003.jpg";
     int[] xPoints = {100,150,200,240,300};
     int[] yPoints = {200,60,280,160,100};
     int nPoints = 5;
     Color lineColor = Color.RED;
     String toPath = "D:/test/desk/polyline-003.jpg";
     String imageFormat = "jpg";
     imageObj.drawPolyline(srcImagePath, xPoints, yPoints, nPoints, lineColor,toPath, imageFormat);//������
      */     
     
     /*
     int x1 = 50;
     int y1 = 100;
     int x2 = 600;
     int y2 = 150;
     Color lineColor = Color.BLUE;
     imageObj.drawLine(srcImagePath, x1, y1, x2, y2, lineColor,toPath, imageFormat);//���߶�
      */     
     
     /*
     String srcImagePath = "D:/test/fileSource/002.jpg";
     int x = 400;
     int y = 500;
     int width = 10;
     int height = 10;
     Color ovalColor = Color.RED;
     String imageFormat = "jpg";
     String toPath = "D:/test/desk/point-002.jpg";
     imageObj.drawPoint(srcImagePath, x, y, width, height, ovalColor, imageFormat, toPath);//��һ��Բ��
     */
     
     /*List pointList = new ArrayList();
     Point p1 = new Point(60,80);
     pointList.add(p1);
     Point p2 = new Point(160,80);
     pointList.add(p2);
     Point p3 = new Point(60,180);
     pointList.add(p3);
     Point p4 = new Point(260,180);
     pointList.add(p4);
     Point p5 = new Point(460,380);
     pointList.add(p5);
     String srcImagePath = "D:/test/fileSource/004.jpg";
     int width = 10;
     int height = 10;
     Color ovalColor = Color.RED;
     String imageFormat = "jpg";
     String toPath = "D:/test/desk/points-004.jpg";
     imageObj.drawPoints(srcImagePath, pointList, width, height, ovalColor, imageFormat, toPath);//����һ�飨�������
      */   
     
     /*
     int[] xPoints = {50,100,180,400,600};
     int[] yPoints = {200,100,160,300,640};
     int nPoints = 5;
     Color lineColor = Color.PINK;
     String srcImagePath = "D:/test/fileSource/003.jpg";
     String toPath = "D:/test/desk/showpoints-003.jpg";
     imageObj.drawPolylineShowPoints(srcImagePath, xPoints, yPoints, nPoints, lineColor, width, height, ovalColor, toPath, imageFormat);//�����߲�ͻ����ʾ��
      */   
     
     /*
     String srcImagePath ="D:/test/fileSource/004.jpg"; 
     int[] xPoints ={50,90,180,320,640};
     int[] yPoints ={200,300,120,240,360};
     int nPoints = 5;
     Color polygonColor = Color.PINK;
     float alpha = (float) 0.2;
     String imageFormat ="jpg";
     String toPath ="D:/test/desk/drawalpha-004.jpg";
     imageObj.drawAndAlphaPolygon(srcImagePath, xPoints, yPoints, nPoints, polygonColor, alpha, imageFormat, toPath);
     */
     /*
     String negativeImagePath = "D:/test/fileSource/001.jpg";
     String additionImagePath = "D:/test/fileSource/006.png";
     String  toPath = "D:/test/fileSource/001.jpg";
     long start = System.currentTimeMillis();
     for(int i=0;i<1000;i++){
      Random rand = new Random();
      int x = rand.nextInt(1024);
      int y =  rand.nextInt(768);
      imageObj.mergeBothImage(negativeImagePath, additionImagePath, x, y, toPath);//ÿ�θ��Ӻϲ�һ��ͼƬ(ѭ�����ɴ�)
     }
     long end = System.currentTimeMillis();
     System.out.println(end-start);*/
     //100 -- 45844
     //1000 -- 411156
     /*�Ľ�˼·����mergeBothImage���� �޸�ΪmergeImageList������
     ͨ����ͼƬ�������װ��list������Ȼ����ȡ��һ���ڷ�����һ������ͼƬ�ϲ�,
     ����ÿ�ζ��򿪵�ͼ������ϳ�ͼƬ���ر���*/

     //�������ͼ��
     /*String negativeImagePath = "D:/test/fileSource/001.jpg";
     String  toPath = "D:/test/fileSource/001.jpg";
     String additionImagePath = "D:/test/fileSource/007.png";
     List additionImageList = new ArrayList();
     int count = 0;
     for(int i=0;i<100;i++){//Ϊʲô������������һ���������������
      Random rand = new Random();
      int x = rand.nextInt(1020);
      String xStr = x+"";
      int y =  rand.nextInt(760);
      String yStr = y +"";
      String[] str = {xStr,yStr,additionImagePath};
      additionImageList.add(str);
      count++;
      //System.out.println(xStr+"   :     "+yStr);
     }
     System.out.println(count);
     long start = System.currentTimeMillis();
     imageObj.mergeImageList(negativeImagePath, additionImageList,"jpg", toPath);
     long end = System.currentTimeMillis();
     System.out.println(end-start);*/
     //                                ��һ��        �ڶ���      ������
     //100�ź�ʱ(����)  --2003   1792   1869           1747         1871         1793
     //1000�ź�ʱ(����) --15334   15200  15236         15903   16028  15545
     //10000�ź�ʱ(����) --153010  153340   152673       154978    156506   154854                               
     //���list.size()<=100,����ô˷�����
     //���list.size()>100,�����Jmagick�ķ�����
     
     /*List iamgePathList = new ArrayList();  // D:/test/16a/
     iamgePathList.add("D:/test/16a/12384_2492.jpg");
     iamgePathList.add("D:/test/16a/12384_2493.jpg");
     iamgePathList.add("D:/test/16a/12384_2494.jpg");
     iamgePathList.add("D:/test/16a/12384_2495.jpg");
     iamgePathList.add("D:/test/16a/12384_2496.jpg");
     iamgePathList.add("D:/test/16a/12384_2497.jpg");
     iamgePathList.add("D:/test/16a/12384_2498.jpg");
     iamgePathList.add("D:/test/16a/12384_2499.jpg");
     iamgePathList.add("D:/test/16a/12384_2500.jpg");
     iamgePathList.add("D:/test/16a/12384_2501.jpg");
     iamgePathList.add("D:/test/16a/12384_2502.jpg");*/
     //String imageFormat = "jpg";
     //String toPath = "D:/test/desk/16a_v1.jpg";
     //imageObj.joinImageListHorizontal(iamgePathList, imageFormat, toPath);
     
     /*String imageFormat = "jpg";
     String[] pics1 = {"D:/test/16a/12384_2502.jpg","D:/test/16a/12384_2501.jpg",
       "D:/test/16a/12384_2500.jpg","D:/test/16a/12384_2499.jpg","D:/test/16a/12384_2498.jpg",
       "D:/test/16a/12384_2497.jpg","D:/test/16a/12384_2496.jpg","D:/test/16a/12384_2495.jpg",
       "D:/test/16a/12384_2494.jpg","D:/test/16a/12384_2493.jpg","D:/test/16a/12384_2492.jpg"};
     
     String[] pics2 = {"D:/test/16a/12385_2502.jpg","D:/test/16a/12385_2501.jpg",
       "D:/test/16a/12385_2500.jpg","D:/test/16a/12385_2499.jpg","D:/test/16a/12385_2498.jpg",
       "D:/test/16a/12385_2497.jpg","D:/test/16a/12385_2496.jpg","D:/test/16a/12385_2495.jpg",
       "D:/test/16a/12385_2494.jpg","D:/test/16a/12385_2493.jpg","D:/test/16a/12385_2492.jpg"};
     
     String[] pics3 = {"D:/test/16a/12386_2502.jpg","D:/test/16a/12386_2501.jpg",
       "D:/test/16a/12386_2500.jpg","D:/test/16a/12386_2499.jpg","D:/test/16a/12386_2498.jpg",
       "D:/test/16a/12386_2497.jpg","D:/test/16a/12386_2496.jpg","D:/test/16a/12386_2495.jpg",
       "D:/test/16a/12386_2494.jpg","D:/test/16a/12386_2493.jpg","D:/test/16a/12386_2492.jpg"};
     
     String[] pics4 = {"D:/test/16a/12387_2502.jpg","D:/test/16a/12387_2501.jpg",
       "D:/test/16a/12387_2500.jpg","D:/test/16a/12387_2499.jpg","D:/test/16a/12387_2498.jpg",
       "D:/test/16a/12387_2497.jpg","D:/test/16a/12387_2496.jpg","D:/test/16a/12387_2495.jpg",
       "D:/test/16a/12387_2494.jpg","D:/test/16a/12387_2493.jpg","D:/test/16a/12387_2492.jpg"};
     
     String[] pics5 = {"D:/test/16a/12388_2502.jpg","D:/test/16a/12388_2501.jpg",
       "D:/test/16a/12388_2500.jpg","D:/test/16a/12388_2499.jpg","D:/test/16a/12388_2498.jpg",
       "D:/test/16a/12388_2497.jpg","D:/test/16a/12388_2496.jpg","D:/test/16a/12388_2495.jpg",
       "D:/test/16a/12388_2494.jpg","D:/test/16a/12388_2493.jpg","D:/test/16a/12388_2492.jpg"};
     
     String[] pics6 = {"D:/test/16a/12389_2502.jpg","D:/test/16a/12389_2501.jpg",
       "D:/test/16a/12389_2500.jpg","D:/test/16a/12389_2499.jpg","D:/test/16a/12389_2498.jpg",
       "D:/test/16a/12389_2497.jpg","D:/test/16a/12389_2496.jpg","D:/test/16a/12389_2495.jpg",
       "D:/test/16a/12389_2494.jpg","D:/test/16a/12389_2493.jpg","D:/test/16a/12389_2492.jpg"};
     
     String toPath1 = "D:/test/desk/16a_v1.jpg";
     String toPath2 = "D:/test/desk/16a_v2.jpg";
     String toPath3 = "D:/test/desk/16a_v3.jpg";
     String toPath4 = "D:/test/desk/16a_v4.jpg";
     String toPath5 = "D:/test/desk/16a_v5.jpg";
     String toPath6 = "D:/test/desk/16a_v6.jpg";
     
     String[] pics7 = {toPath1,toPath2,toPath3,toPath4,toPath5,toPath6};
     String toPath7 = "D:/test/desk/16a_h1.jpg";
     
     long start = System.currentTimeMillis();
     imageObj.joinImageListVertical(pics1, imageFormat, toPath1);
     imageObj.joinImageListVertical(pics2, imageFormat, toPath2);
     imageObj.joinImageListVertical(pics3, imageFormat, toPath3);
     imageObj.joinImageListVertical(pics4, imageFormat, toPath4);
     imageObj.joinImageListVertical(pics5, imageFormat, toPath5);
     imageObj.joinImageListVertical(pics6, imageFormat, toPath6);
     
     imageObj.joinImageListHorizontal(pics7, imageFormat, toPath7);
     long end = System.currentTimeMillis();
     System.out.println(end-start);*/
     
     String str = "����\n�Ϻ�\n����\n����";
     System.out.println(str);
     String path = "c:/relevantdata.txt";
     FileOutputStream fops = new FileOutputStream(path);
     fops.write(str.getBytes());
     
     BufferedReader inputStream = new BufferedReader(new FileReader(new File(path)));
     String mrMsg = "";
     while((mrMsg = inputStream.readLine())!=null){
     System.out.println(mrMsg);
     }
     }
     //����  11   11x6
     //����  375  
     //����  391  3250
}