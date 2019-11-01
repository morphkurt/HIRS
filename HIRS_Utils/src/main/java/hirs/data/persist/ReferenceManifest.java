package hirs.data.persist;

import java.io.StringReader;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 */
@Entity
@Table(name = "ReferenceManifest")
@XmlRootElement(name = "rim")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReferenceManifest extends Baseline {

    private static final Logger LOGGER = LogManager.getLogger();

    private static final String RIM_TYPE_PRIMARY = "Primary";
    private static final String RIM_TYPE_SUPPLEMENTAL = "Supplemental";
    private static final String RIM_TYPE_PATCH = "Patch";

    @Column
    private String manufacturer = null;
    @Column
    private String model = null;
    @Column
    private String firmwareVersion = null;
    @Column
    private String tagId = null;
    @Column
    private String rimType = null;

    /**
     * Returns a new <code>Device</code> instance from the XML string. This
     * unmarshals the XML string and generates a <code>ReferenceManifest</code>
     * object.
     * This is a utility method for creating <code>ReferenceManifest</code>
     * objects.
     *
     * @param xml
     *            XML representation of device
     * @return device
     * @throws JAXBException
     *             if unable to unmarshal the string
     */
    public static ReferenceManifest getInstance(final String xml) throws JAXBException {
        final JAXBContext context = JAXBContext.newInstance(Device.class);
        final Unmarshaller unmarshaller = context.createUnmarshaller();
        final StringReader reader = new StringReader(xml);
        return (ReferenceManifest) unmarshaller.unmarshal(reader);
    }

    /**
     * Getter for the manufacturuer info.
     * @return string for the manufacturuer
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * Setter for the manufacturuer info.
     * @param manufacturer passed in info.
     */
    public void setManufacturer(final String manufacturer) {
        this.manufacturer = manufacturer;
    }

    /**
     * Getter for the model info.
     * @return string for the model
     */
    public String getModel() {
        return model;
    }

    /**
     * Setter for the Model info.
     * @param model passed in model
     */
    public void setModel(final String model) {
        this.model = model;
    }

    /**
     * Getter for the firmware version info.
     * @return string for the firmware version
     */
    public String getFirmwareVersion() {
        return firmwareVersion;
    }

    /**
     * Setter for the firmware version info.
     * @param firmwareVersion passed in firmware version
     */
    public void setFirmwareVersion(final String firmwareVersion) {
        this.firmwareVersion = firmwareVersion;
    }

    /**
     * Getter for the RIM Tag ID.
     * @return string for the RIM tag id
     */
    public String getTagId() {
        return tagId;
    }

    /**
     * Setter for the RIM Tag ID.
     * @param tagId passed in RIM Tag ID
     */
    public void setTagId(final String tagId) {
        this.tagId = tagId;
    }

    /**
     * Getter for the RIM Type (Primary, Supplemental, Patch).
     * @return string for the RIM Type
     */
    public String getRimType() {
        return rimType;
    }

    /**
     * Setter for the RIM Type.
     * @param type passed in RIM Type
     */
    public void setRimType(final String type) {
        this.rimType = type;
    }
}
