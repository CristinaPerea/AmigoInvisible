package model;

public class clsEvent {

    private Integer data_id_event;
    private String  data_name;
    private String  data_date;
    private String  data_place;
    private Integer data_max_Price;

    public clsEvent( Integer data_id_event
                   , String  data_name
                   , String  data_date
                   , String  data_place
                   , Integer data_max_Price
                   ){
        this.data_id_event  = data_id_event;
        this.data_name      = data_name;
        this.data_date      = data_date;
        this.data_place     = data_place;
        this.data_max_Price = data_max_Price;
    }

    public Integer getData_id_event() {
        return data_id_event;
    }

    public void setData_id_event(Integer data_id_event) {
        this.data_id_event = data_id_event;
    }

    public String getData_name() {
        return data_name;
    }

    public void setData_name(String data_name) {
        this.data_name = data_name;
    }

    public String getData_date() {
        return data_date;
    }

    public void setData_date(String data_date) {
        this.data_date = data_date;
    }

    public String getData_place() {
        return data_place;
    }

    public void setData_place(String data_place) {
        this.data_place = data_place;
    }

    public Integer getData_max_Price() {
        return data_max_Price;
    }

    public void setData_max_Price(Integer data_max_Price) {
        this.data_max_Price = data_max_Price;
    }
}