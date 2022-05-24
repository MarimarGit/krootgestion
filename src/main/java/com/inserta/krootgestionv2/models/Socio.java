package com.inserta.krootgestionv2.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table (name = "socios", uniqueConstraints = {@UniqueConstraint(columnNames = {"dni"})})
public class Socio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String dni;
    private String tarjetaSanitaria;
    private String pasaporte;
    private LocalDateTime fechaNacimiento;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String diagnostico;
    private int idGenero;
    private int idEstado;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_tipo_socio")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private TipoSocio tipoSocio;
    //private int idTipoSocio;

    private String domicilio;
    private String codigoPostal;
    private int idPoblacion;
    private int idProvincia;
    private int idPais;
    private String emailPrincipal;
    private String emailSecundario;
    private String telefonoFijo;
    private String telefonoMovil;
    private boolean lopd;
    private String urlFoto;
    private int idFormaPago;
    @Column (columnDefinition = "TIMESTAMP")
    private LocalDateTime fechaRegistro;
    @Column (columnDefinition = "TIMESTAMP")
    private LocalDateTime fechaUltimoAcceso;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTarjetaSanitaria() {
        return tarjetaSanitaria;
    }

    public void setTarjetaSanitaria(String tarjetaSanitaria) {
        this.tarjetaSanitaria = tarjetaSanitaria;
    }

    public String getPasaporte() {
        return pasaporte;
    }

    public void setPasaporte(String pasaporte) {
        this.pasaporte = pasaporte;
    }

    public LocalDateTime getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public int getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public TipoSocio getTipoSocio() {
        return tipoSocio;
    }

    public void setTipoSocio(TipoSocio tipoSocio) {
        this.tipoSocio = tipoSocio;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public int getIdPoblacion() {
        return idPoblacion;
    }

    public void setIdPoblacion(int idPoblacion) {
        this.idPoblacion = idPoblacion;
    }

    public int getIdProvincia() {
        return idProvincia;
    }

    public void setIdProvincia(int idProvincia) {
        this.idProvincia = idProvincia;
    }

    public int getIdPais() {
        return idPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    public String getEmailPrincipal() {
        return emailPrincipal;
    }

    public void setEmailPrincipal(String emailPrincipal) {
        this.emailPrincipal = emailPrincipal;
    }

    public String getEmailSecundario() {
        return emailSecundario;
    }

    public void setEmailSecundario(String emailSecundario) {
        this.emailSecundario = emailSecundario;
    }

    public String getTelefonoFijo() {
        return telefonoFijo;
    }

    public void setTelefonoFijo(String telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }

    public String getTelefonoMovil() {
        return telefonoMovil;
    }

    public void setTelefonoMovil(String telefonoMovil) {
        this.telefonoMovil = telefonoMovil;
    }

    public boolean isLopd() {
        return lopd;
    }

    public void setLopd(boolean lopd) {
        this.lopd = lopd;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public int getIdFormaPago() {
        return idFormaPago;
    }

    public void setIdFormaPago(int idFormaPago) {
        this.idFormaPago = idFormaPago;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public LocalDateTime getFechaUltimoAcceso() {
        return fechaUltimoAcceso;
    }

    public void setFechaUltimoAcceso(LocalDateTime fechaUltimoAcceso) {
        this.fechaUltimoAcceso = fechaUltimoAcceso;
    }

    @Override
    public String toString() {
        return "Socio{" +
                "id=" + id +
                ", dni='" + dni + '\'' +
                ", tarjetaSanitaria='" + tarjetaSanitaria + '\'' +
                ", pasaporte='" + pasaporte + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", nombre='" + nombre + '\'' +
                ", apellido1='" + apellido1 + '\'' +
                ", apellido2='" + apellido2 + '\'' +
                ", diagnostico='" + diagnostico + '\'' +
                ", idGenero=" + idGenero +
                ", idEstado=" + idEstado +
                ", tipoSocio=" + tipoSocio +
                ", domicilio='" + domicilio + '\'' +
                ", codigoPostal='" + codigoPostal + '\'' +
                ", idPoblacion=" + idPoblacion +
                ", idProvincia=" + idProvincia +
                ", idPais=" + idPais +
                ", emailPrincipal='" + emailPrincipal + '\'' +
                ", emailSecundario='" + emailSecundario + '\'' +
                ", telefonoFijo='" + telefonoFijo + '\'' +
                ", telefonoMovil='" + telefonoMovil + '\'' +
                ", lopd=" + lopd +
                ", urlFoto='" + urlFoto + '\'' +
                ", idFormaPago=" + idFormaPago +
                ", fechaRegistro=" + fechaRegistro +
                ", fechaUltimoAcceso=" + fechaUltimoAcceso +
                '}';
    }
}