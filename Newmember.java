package com.example.sahil.registration;



public class Newmember {

    private String Newname;
    private String id;
    private String Newamount;
    private String Newemail;
    private String Newphone;
    private String Newevent;



    public Newmember()
    {

    }

    public Newmember(String id,String Newname, String Newemail,String Newphone,String Newevent,String Newamount)
    {
        this.id = id;
        this.Newname = Newname;
        this.Newemail = Newemail;
        this.Newphone = Newphone;
        this.Newevent = Newevent;
        this.Newamount = Newamount;

    }


    public String getNewname() {
        return Newname;
    }

    public String getNewamount() {
        return Newamount;
    }


    public String getNewemail() {
        return Newemail;
    }

    public String getNewphone() {
        return Newphone;
    }

    public String getNewevent() {
        return Newevent;
    }



}
