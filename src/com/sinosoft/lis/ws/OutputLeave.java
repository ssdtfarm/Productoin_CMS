/**
 * OutputLeave.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sinosoft.lis.ws;

import com.sinosoft.utility.ExeSQL;

public class OutputLeave  implements java.io.Serializable {
    private java.math.BigInteger pin;

    private java.lang.String strStatus;

    private static String mIP  = getIP();
    private static String getIP(){
    	ExeSQL tExeSQL = new ExeSQL();
    	return tExeSQL.getOneValue("select code from ldcode where codetype='webservice' and codename='IPPORT' ");
    }
    public OutputLeave() {
    }

    public OutputLeave(
           java.math.BigInteger pin,
           java.lang.String strStatus) {
           this.pin = pin;
           this.strStatus = strStatus;
    }


    /**
     * Gets the pin value for this OutputLeave.
     * 
     * @return pin
     */
    public java.math.BigInteger getPin() {
        return pin;
    }


    /**
     * Sets the pin value for this OutputLeave.
     * 
     * @param pin
     */
    public void setPin(java.math.BigInteger pin) {
        this.pin = pin;
    }


    /**
     * Gets the strStatus value for this OutputLeave.
     * 
     * @return strStatus
     */
    public java.lang.String getStrStatus() {
        return strStatus;
    }


    /**
     * Sets the strStatus value for this OutputLeave.
     * 
     * @param strStatus
     */
    public void setStrStatus(java.lang.String strStatus) {
        this.strStatus = strStatus;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OutputLeave)) return false;
        OutputLeave other = (OutputLeave) obj;
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
            ((this.strStatus==null && other.getStrStatus()==null) || 
             (this.strStatus!=null &&
              this.strStatus.equals(other.getStrStatus())));
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
        if (getStrStatus() != null) {
            _hashCode += getStrStatus().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OutputLeave.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://"+mIP+"/Leave.xsd", "outputLeave"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pin");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "integer"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("strStatus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "strStatus"));
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
