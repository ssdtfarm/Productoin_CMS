/**
 * InputEmployee.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sinosoft.lis.ws;

import com.sinosoft.utility.ExeSQL;

public class InputEmployee  implements java.io.Serializable {
    private java.math.BigInteger pin;

    private java.lang.String ename;

    private java.lang.String deptCode;
    
    private static String mIP  = getIP();
    private static String getIP(){
    	ExeSQL tExeSQL = new ExeSQL();
    	return tExeSQL.getOneValue("select code from ldcode where codetype='webservice' and codename='IPPORT' ");
    }

    public InputEmployee() {
    }

    public InputEmployee(
           java.math.BigInteger pin,
           java.lang.String ename,
           java.lang.String deptCode) {
           this.pin = pin;
           this.ename = ename;
           this.deptCode = deptCode;
    }


    /**
     * Gets the pin value for this InputEmployee.
     * 
     * @return pin
     */
    public java.math.BigInteger getPin() {
        return pin;
    }


    /**
     * Sets the pin value for this InputEmployee.
     * 
     * @param pin
     */
    public void setPin(java.math.BigInteger pin) {
        this.pin = pin;
    }


    /**
     * Gets the ename value for this InputEmployee.
     * 
     * @return ename
     */
    public java.lang.String getEname() {
        return ename;
    }


    /**
     * Sets the ename value for this InputEmployee.
     * 
     * @param ename
     */
    public void setEname(java.lang.String ename) {
        this.ename = ename;
    }


    /**
     * Gets the deptCode value for this InputEmployee.
     * 
     * @return deptCode
     */
    public java.lang.String getDeptCode() {
        return deptCode;
    }


    /**
     * Sets the deptCode value for this InputEmployee.
     * 
     * @param deptCode
     */
    public void setDeptCode(java.lang.String deptCode) {
        this.deptCode = deptCode;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof InputEmployee)) return false;
        InputEmployee other = (InputEmployee) obj;
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
            ((this.ename==null && other.getEname()==null) || 
             (this.ename!=null &&
              this.ename.equals(other.getEname()))) &&
            ((this.deptCode==null && other.getDeptCode()==null) || 
             (this.deptCode!=null &&
              this.deptCode.equals(other.getDeptCode())));
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
        if (getEname() != null) {
            _hashCode += getEname().hashCode();
        }
        if (getDeptCode() != null) {
            _hashCode += getDeptCode().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(InputEmployee.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://"+mIP+"/Employee.xsd", "inputEmployee"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pin");
        elemField.setXmlName(new javax.xml.namespace.QName("", "pin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "integer"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ename");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ename"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deptCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "deptCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
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
