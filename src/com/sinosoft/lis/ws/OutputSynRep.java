/**
 * OutputSynRep.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sinosoft.lis.ws;

import com.sinosoft.utility.ExeSQL;

public class OutputSynRep  implements java.io.Serializable {
    private java.math.BigInteger pin;

    private java.lang.String duty;

    private java.lang.String realduty;

    private static String mIP  = getIP();
    private static String getIP(){
    	ExeSQL tExeSQL = new ExeSQL();
    	return tExeSQL.getOneValue("select code from ldcode where codetype='webservice' and codename='IPPORT'");
    }
    public OutputSynRep() {
    }

    public OutputSynRep(
           java.math.BigInteger pin,
           java.lang.String duty,
           java.lang.String realduty) {
           this.pin = pin;
           this.duty = duty;
           this.realduty = realduty;
    }


    /**
     * Gets the pin value for this OutputSynRep.
     * 
     * @return pin
     */
    public java.math.BigInteger getPin() {
        return pin;
    }


    /**
     * Sets the pin value for this OutputSynRep.
     * 
     * @param pin
     */
    public void setPin(java.math.BigInteger pin) {
        this.pin = pin;
    }


    /**
     * Gets the duty value for this OutputSynRep.
     * 
     * @return duty
     */
    public java.lang.String getDuty() {
        return duty;
    }


    /**
     * Sets the duty value for this OutputSynRep.
     * 
     * @param duty
     */
    public void setDuty(java.lang.String duty) {
        this.duty = duty;
    }


    /**
     * Gets the realduty value for this OutputSynRep.
     * 
     * @return realduty
     */
    public java.lang.String getRealduty() {
        return realduty;
    }


    /**
     * Sets the realduty value for this OutputSynRep.
     * 
     * @param realduty
     */
    public void setRealduty(java.lang.String realduty) {
        this.realduty = realduty;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OutputSynRep)) return false;
        OutputSynRep other = (OutputSynRep) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.pin==null && other.getPin()==null) || 
             (this.pin!=null &&
              this.pin.equals(other.getPin()))) &&
            ((this.duty==null && other.getDuty()==null) || 
             (this.duty!=null &&
              this.duty.equals(other.getDuty()))) &&
            ((this.realduty==null && other.getRealduty()==null) || 
             (this.realduty!=null &&
              this.realduty.equals(other.getRealduty())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getPin() != null) {
            _hashCode += getPin().hashCode();
        }
        if (getDuty() != null) {
            _hashCode += getDuty().hashCode();
        }
        if (getRealduty() != null) {
            _hashCode += getRealduty().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OutputSynRep.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://"+mIP+"/SynRep.xsd", "outputSynRep"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pin");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "integer"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("duty");
        elemField.setXmlName(new javax.xml.namespace.QName("", "duty"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("realduty");
        elemField.setXmlName(new javax.xml.namespace.QName("", "realduty"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
