package com.example.ticketapp;

public class infoCaja {
    private String desIncidencia;
    private String aulaincidencia;
    private int imgIncidencia;
    private boolean resolta;

    public infoCaja(String desIncidencia, String aulaincidencia, int imgIncidencia){
        this.desIncidencia = desIncidencia;
        this.aulaincidencia = aulaincidencia;
        this.imgIncidencia = imgIncidencia;
    }

    public String getDesIncidencia() {
        return desIncidencia;
    }

    public String getAulaincidencia(){
        return aulaincidencia;
    }

    public int getImgIncidencia() {
        return imgIncidencia;
    }

    public boolean getResolta(){
        return resolta;
    }

    public void setResolta(boolean t){
        this.resolta = t ;
    }
}
