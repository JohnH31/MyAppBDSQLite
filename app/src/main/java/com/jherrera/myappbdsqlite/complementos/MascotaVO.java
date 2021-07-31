package com.jherrera.myappbdsqlite.complementos;

public class MascotaVO {

    private int idMascota;
    private String nombreMascota;
    private String razaMascota;
    private String colorMascota;
    private int edadMascota;

    public MascotaVO() {
    }

    public MascotaVO(int idMascota, String nombreMascota, String razaMascota, String colorMascota, int edadMascota) {
        this.idMascota = idMascota;
        this.nombreMascota = nombreMascota;
        this.razaMascota = razaMascota;
        this.colorMascota = colorMascota;
        this.edadMascota = edadMascota;
    }

    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public String getRazaMascota() {
        return razaMascota;
    }

    public void setRazaMascota(String razaMascota) {
        this.razaMascota = razaMascota;
    }

    public String getColorMascota() {
        return colorMascota;
    }

    public void setColorMascota(String colorMascota) {
        this.colorMascota = colorMascota;
    }

    public int getEdadMascota() {
        return edadMascota;
    }

    public void setEdadMascota(int edadMascota) {
        this.edadMascota = edadMascota;
    }
}
