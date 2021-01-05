package com.example.android.myapplication;


public class DS
{
    private int image_id;
    private String place_name, location, timing, detail;

    public DS(int image_id,String name, String location, String timing, String detail){
        this.place_name = name;
        this.image_id = image_id;
        this.location = location;
        this.timing = timing;
        this.detail = detail;
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
