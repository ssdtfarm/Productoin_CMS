/**
 * InputDeptFields.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sinosoft.lis.ws;

import com.sinosoft.utility.ExeSQL;

public class InputDeptFields  implements java.io.Serializable {
    private java.lang.String deptCode;

    private java.lang.String deptName;

    private java.lang.String parentCode;

    private static String mIP  = getIP();
    private static String getIP(){
    	ExeSQL tExeSQL = new ExeSQL();
    	return tExeSQL.getOneValue("select code from ldcode where codetype='webservice' and codename='IPPORT' ");
    }
    public InputDeptFields() {
    }

    public InputDeptFields(
           java.lang.String deptCode,
           java.lang.String deptName,
           java.lang.String parentCode) {
           this.deptCode = deptCode;
           this.deptName = deptName;
           this.parentCode = parentCode;
    }


    /**
     * Gets the deptCode value for this InputDeptFields.
     * 
     * @return deptCode
     */
    public java.lang.String getDeptCode() {
        return deptCode;
    }


    /**
     * Sets the deptCode value for this InputDeptFields.
     * 
     * @param deptCode
     */
    public void setDeptCode(java.lang.String deptCode) {
        this.deptCode = deptCode;
    }


    /**
     * Gets the deptName value for this InputDeptFields.
     * 
     * @return deptName
     */
    public java.lang.String getDeptName() {
        return deptName;
    }


    /**
     * Sets the deptName value for this InputDeptFields.
     * 
     * @param deptName
     */
    public void setDeptName(java.lang.String deptName) {
        this.deptName = deptName;
    }


    /**
     * Gets the parentCode value for this InputDeptFields.
     * 
     * @return parentCode
     */
    public java.lang.String getParentCode() {
        return parentCode;
    }


    /**
     * Sets the parentCode value for this InputDeptFields.
     * 
     * @param parentCode
     */
    public void setParentCode(java.lang.String parentCode) {
        this.parentCode = parentCode;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof InputDeptFields)) return false;
        InputDeptFields other = (InputDeptFields) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.deptCode==null && other.getDeptCode()==null) || 
             (this.deptCode!=null &&
              this.deptCode.equals(other.getDeptCode()))) &&
            ((this.deptName==null && other.getDeptName()==null) || 
             (this.deptName!=null &&
              this.deptName.equals(other.getDeptName()))) &&
            ((this.parentCode==null && other.getParentCode()==null) || 
             (this.parentCode!=null &&
              this.parentCode.equals(other.getParentCode())));
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
        if (getDeptCode() != null) {
            _hashCode += getDeptCode().hashCode();
        }
        if (getDeptName() != null) {
            _hashCode += getDeptName().hashCode();
        }
        if (getParentCode() != null) {
            _hashCode += getParentCode().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(InputDeptFields.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://"+mIP+"/Department.xsd", "inputDeptFields"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deptCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "deptCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deptName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "deptName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("parentCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "parentCode"));
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
