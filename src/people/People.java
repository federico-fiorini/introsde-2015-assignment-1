//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.7 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2015.10.22 alle 10:12:17 AM CEST 
//


package people;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per anonymous complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="person" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="firstname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="lastname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="birthdate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="healthprofile">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="lastupdate" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="weight" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *                             &lt;element name="height" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *                             &lt;element name="bmi" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *                 &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "person"
})
@XmlRootElement(name = "people")
public class People {

    protected List<People.Person> person;

    /**
     * Gets the value of the person property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the person property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPerson().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link People.Person }
     * 
     * 
     */
    public List<People.Person> getPerson() {
        if (person == null) {
            person = new ArrayList<People.Person>();
        }
        return this.person;
    }


    /**
     * <p>Classe Java per anonymous complex type.
     * 
     * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="firstname" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="lastname" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="birthdate" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="healthprofile">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="lastupdate" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="weight" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
     *                   &lt;element name="height" type="{http://www.w3.org/2001/XMLSchema}float"/>
     *                   &lt;element name="bmi" type="{http://www.w3.org/2001/XMLSchema}float"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "firstname",
        "lastname",
        "birthdate",
        "healthprofile"
    })
    public static class Person {

        @XmlElement(required = true)
        protected String firstname;
        @XmlElement(required = true)
        protected String lastname;
        @XmlElement(required = true)
        protected String birthdate;
        @XmlElement(required = true)
        protected People.Person.Healthprofile healthprofile;
        @XmlAttribute(name = "id", required = true)
        protected BigDecimal id;

        /**
         * Recupera il valore della proprietà firstname.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFirstname() {
            return firstname;
        }

        /**
         * Imposta il valore della proprietà firstname.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFirstname(String value) {
            this.firstname = value;
        }

        /**
         * Recupera il valore della proprietà lastname.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLastname() {
            return lastname;
        }

        /**
         * Imposta il valore della proprietà lastname.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLastname(String value) {
            this.lastname = value;
        }

        /**
         * Recupera il valore della proprietà birthdate.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getBirthdate() {
            return birthdate;
        }

        /**
         * Imposta il valore della proprietà birthdate.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setBirthdate(String value) {
            this.birthdate = value;
        }

        /**
         * Recupera il valore della proprietà healthprofile.
         * 
         * @return
         *     possible object is
         *     {@link People.Person.Healthprofile }
         *     
         */
        public People.Person.Healthprofile getHealthprofile() {
            return healthprofile;
        }

        /**
         * Imposta il valore della proprietà healthprofile.
         * 
         * @param value
         *     allowed object is
         *     {@link People.Person.Healthprofile }
         *     
         */
        public void setHealthprofile(People.Person.Healthprofile value) {
            this.healthprofile = value;
        }

        /**
         * Recupera il valore della proprietà id.
         * 
         * @return
         *     possible object is
         *     {@link BigDecimal }
         *     
         */
        public BigDecimal getId() {
            return id;
        }

        /**
         * Imposta il valore della proprietà id.
         * 
         * @param value
         *     allowed object is
         *     {@link BigDecimal }
         *     
         */
        public void setId(BigDecimal value) {
            this.id = value;
        }


        /**
         * <p>Classe Java per anonymous complex type.
         * 
         * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="lastupdate" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="weight" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
         *         &lt;element name="height" type="{http://www.w3.org/2001/XMLSchema}float"/>
         *         &lt;element name="bmi" type="{http://www.w3.org/2001/XMLSchema}float"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "lastupdate",
            "weight",
            "height",
            "bmi"
        })
        public static class Healthprofile {

            @XmlElement(required = true)
            protected String lastupdate;
            @XmlElement(required = true)
            protected BigDecimal weight;
            protected float height;
            protected float bmi;

            /**
             * Recupera il valore della proprietà lastupdate.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getLastupdate() {
                return lastupdate;
            }

            /**
             * Imposta il valore della proprietà lastupdate.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setLastupdate(String value) {
                this.lastupdate = value;
            }

            /**
             * Recupera il valore della proprietà weight.
             * 
             * @return
             *     possible object is
             *     {@link BigDecimal }
             *     
             */
            public BigDecimal getWeight() {
                return weight;
            }

            /**
             * Imposta il valore della proprietà weight.
             * 
             * @param value
             *     allowed object is
             *     {@link BigDecimal }
             *     
             */
            public void setWeight(BigDecimal value) {
                this.weight = value;
            }

            /**
             * Recupera il valore della proprietà height.
             * 
             */
            public float getHeight() {
                return height;
            }

            /**
             * Imposta il valore della proprietà height.
             * 
             */
            public void setHeight(float value) {
                this.height = value;
            }

            /**
             * Recupera il valore della proprietà bmi.
             * 
             */
            public float getBmi() {
                return bmi;
            }

            /**
             * Imposta il valore della proprietà bmi.
             * 
             */
            public void setBmi(float value) {
                this.bmi = value;
            }

        }

    }

}
