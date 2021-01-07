package com.example.android.myapplication;


public class DS
{
    private int image_id;
    private String place_name, location, timing, detail, geo_location;
    private int[] detail_images;

    public DS(int image_id, String name, String location, String timing, String detail, String geo_location, int[] detail_images){
        this.place_name = name;
        this.image_id = image_id;
        this.location = location;
        this.timing = timing;
        this.detail = detail;
        this.geo_location= geo_location;
        this.detail_images = detail_images;
    }

    public int get_image_id()
    {
        return image_id;
    }

    public String getplace_name()
    {
        return place_name;
    }

    public String get_location()
    {
        return location;
    }

    public String get_timing()
    {
        return timing;
    }

    public String get_detail()
    {
        return detail;
    }

    public String get_geo_location()
    {
        return geo_location;
    }

    public int[] getDetail_images()
    {
        return detail_images;
    }

    @Override
    public String toString() {
        return "DS{" +
                "name=" + place_name + '\'' +
                ", image_id=" + image_id + '\'' +
                ", location='" + location + '\'' +
                ", timing='" + timing + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }
}
