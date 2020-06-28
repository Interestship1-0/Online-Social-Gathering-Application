package com.coolab;

class SettingDetails {


    int imgId;
    String mainText;
    String subText;

    public SettingDetails() {
    }

    public SettingDetails(int imgId, String mainText, String subText) {
        this.imgId = imgId;
        this.mainText = mainText;
        this.subText = subText;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getMainText() {
        return mainText;
    }

    public void setMainText(String mainText) {
        this.mainText = mainText;
    }

    public String getSubText() {
        return subText;
    }

    public void setSubText(String subText) {
        this.subText = subText;
    }
}
