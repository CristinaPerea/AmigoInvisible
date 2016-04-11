package model;

import android.graphics.Bitmap;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ClsEvent {

    private Integer data_id_event;
    private String  data_name;
    private String  data_date;
    private String  data_place;
    private Integer data_max_Price;
    private Bitmap  data_photo;

    public ClsEvent(Integer data_id_event
            , String data_name
            , String data_date
            , String data_place
            , Integer data_max_Price
            , Bitmap data_photo
    ){
        this.data_id_event  = data_id_event;
        this.data_name      = data_name;
        this.data_date      = data_date;
        this.data_place     = data_place;
        this.data_max_Price = data_max_Price;
        this.data_photo     = data_photo;
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

    public Bitmap getData_photo() {
        return data_photo;
    }

    public void setData_photo(Bitmap data_photo) {
        this.data_photo = data_photo;
    }

    private Calendar getDate(){
        Calendar cal = null;
        try {

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date fecha = formatter.parse(getData_date());
            cal = Calendar.getInstance();
            cal.setTime(fecha);
        }catch(ParseException e){;}
        return cal;
    }
    public String getData_date_text()
    {
        String[] diaSem = new String[]{"Sábado", "Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes"};
        String[] mesAño = new String[]{"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

        Calendar cal = getDate();
        int dayWeek  = cal.get(Calendar.DAY_OF_WEEK);
        int month    = cal.get(Calendar.MONTH);
        int day      = cal.get(Calendar.DAY_OF_MONTH);
        String fecha = diaSem[dayWeek] + ", "  + day + " de " + mesAño[month] ;
        return fecha;
    }

    public String getData_date_time()
    {
        Calendar cal = getDate();
        int hour     = cal.get(Calendar.HOUR_OF_DAY);
        int minute   = cal.get(Calendar.MINUTE);
        String fecha = "" + hour + ":"  + minute;
        return fecha;
    }

    @Override
    public String toString() {
        return "ClsEvent{" +
                "id_event=" + data_id_event +
                ", name='" + data_name + '\'' +
                ", date='" + data_date + '\'' +
                ", place='" + data_place + '\'' +
                ", max_Price=" + data_max_Price +
                '}';
    }
}