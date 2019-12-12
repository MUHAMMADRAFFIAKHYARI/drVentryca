package android.example.drventryca.Model;

public class HealthNewsModel {



    private String title;
    private String desc;
    private String imgUrl;
    private String pubD;

    public HealthNewsModel(String title, String desc, String imgUrl, String pubD) {
        this.title = title;
        this.desc = desc;
        this.imgUrl = imgUrl;
        this.pubD = pubD;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getPubD() {
        return pubD;
    }
}
