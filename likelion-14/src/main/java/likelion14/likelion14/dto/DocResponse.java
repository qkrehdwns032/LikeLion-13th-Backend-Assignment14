package likelion14.likelion14.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@XmlRootElement(name = "response")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
@NoArgsConstructor
public class DocResponse {

    private Header header;

    private Body body;

    @XmlAccessorType(XmlAccessType.FIELD)
    @Data
    @NoArgsConstructor
    public static class Header{
        private String resultCode;

        private String resultMsg;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @Data
    @NoArgsConstructor
    public static class Body{

        private Items items;

        @XmlElement(name = "numOfRows")
        private Integer numOfRows;

        @XmlElement(name = "pageNo")
        private Integer pageNo;

        @XmlElement(name = "totalCount")
        private Integer totalCount;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @Data
    @NoArgsConstructor
    public static class Items{

        @XmlElement(name = "item")
        private List<DocItem> item;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @Data
    @NoArgsConstructor
    public static class DocItem{

        @XmlElement(name = "addr")
        private String addr;

        @XmlElement(name = "cpetType")
        private String cpetType;

        @XmlElement(name = "drSpec")
        private String drSpec;

        @XmlElement(name = "mdcareAdminNm")
        private String mdcareAdminNm;

        @XmlElement(name = "portal")
        private Boolean portal;

        @XmlElement(name = "telNo")
        private String telNo;
    }
}
