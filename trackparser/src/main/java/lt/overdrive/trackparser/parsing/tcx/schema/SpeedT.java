//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.12.17 at 10:24:25 PM EET 
//


package lt.overdrive.trackparser.parsing.tcx.schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Speed_t complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Speed_t">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2}Target_t">
 *       &lt;sequence>
 *         &lt;element name="SpeedZone" type="{http://www.garmin.com/xmlschemas/TrainingCenterDatabase/v2}Zone_t"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Speed_t", propOrder = {
    "speedZone"
})
public class SpeedT
    extends TargetT
{

    @XmlElement(name = "SpeedZone", required = true)
    protected ZoneT speedZone;

    /**
     * Gets the value of the speedZone property.
     * 
     * @return
     *     possible object is
     *     {@link ZoneT }
     *     
     */
    public ZoneT getSpeedZone() {
        return speedZone;
    }

    /**
     * Sets the value of the speedZone property.
     * 
     * @param value
     *     allowed object is
     *     {@link ZoneT }
     *     
     */
    public void setSpeedZone(ZoneT value) {
        this.speedZone = value;
    }

}
