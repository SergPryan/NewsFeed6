package main.beans;

import main.controllers.NewsController;

import main.entities.News;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import javax.faces.event.ValueChangeEvent;

import javax.servlet.http.Part;

import java.io.*;

import java.util.List;

//the main class for the jsf
@ManagedBean
@SessionScoped
public class NewsBean implements Serializable {

    private News news=new News();
    private List<News> list;
    private NewsController newsController;
    //number of news displayed on the page
    private int[] amountNews={20,50,100};
    private int currentAmount=amountNews[2];

    //downloadable file
    private Part partImage;

    //first initialization
    {
        newsController =new NewsController();
        list= newsController.getAllNews(100);
    }

    // entry base
    public String createNews(){
        uploadFile();
        newsController.createNews(this.news);
        news=new News();
        return "addNews";
    }

    //change the number of displayed news
    public void changeCountViewNews(ValueChangeEvent event){
        this.list= newsController.getAllNews(Integer.valueOf(event.getNewValue().toString()));
    }

    //loading image files in an object property news
    private void uploadFile(){
        try {
        InputStream is = partImage.getInputStream();
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        int nRead;
        byte[] data = new byte[16384];
        while ((nRead = is.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, nRead);
        }
        buffer.flush();
        news.setImage(buffer.toByteArray());
        buffer.close();
        }
        catch (IOException e){
        }
    }

    //getters and setters
    public int[] getAmountNews() {
        return amountNews;
    }

    public void setAmountNews(int[] amountNews) {
        this.amountNews = amountNews;
    }

    public int getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(int currentAmount) {
        this.currentAmount = currentAmount;
    }

    public Part getPartImage() {
        return partImage;
    }

    public void setPartImage(Part partImage) {
        this.partImage = partImage;
    }

    public List<News> getList() {
        return list;
    }

    public void setList(List<News> list) {
        this.list = list;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    public NewsController getNewsController() {
        return newsController;
    }

    public void setNewsController(NewsController newsController) {
        this.newsController = newsController;
    }

    //    public String uploadFile() {
//        if (partImage != null) {
////            try {
////                FacesContext facesContext = FacesContext.getCurrentInstance();
////                File file = new File(".."+File.separator+"images"+File.separator+partImage.getSubmittedFileName());
////                Files.copy(partImage.getInputStream(),file.toPath());
////                System.out.println(file.getAbsolutePath());
//
////            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
////            String path = context.getRequestContextPath();
////            String p=context.getResourcePaths("images").toString();
////            System.out.println(path);
//
//            try {
////                URL url = FacesContext.getCurrentInstance().getExternalContext().getResource("/resources/images/");
//                String tmp = FacesContext.getCurrentInstance().getExternalContext().getResource("/resources/images/").getPath().substring(1);
//                String tmp2 = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("images").toString();
//                System.out.println(tmp2);
////                System.out.println(tmp2);
////                System.out.println(url);
////                System.out.println(partImage.getSubmittedFileName());
////                OutputStream fos =new FileOutputStream(url+partImage.getSubmittedFileName());
//
//                Files.copy(partImage.getInputStream(),new File(tmp,partImage.getSubmittedFileName()).toPath());
////                Files.copy(partImage.getInputStream(),new File();
//            } catch (MalformedURLException e) {
//                e.printStackTrace();
//            }
//            catch (IOException e){
//                e.printStackTrace();
//            }
//        }
//        return "addNews";
//    }

}
