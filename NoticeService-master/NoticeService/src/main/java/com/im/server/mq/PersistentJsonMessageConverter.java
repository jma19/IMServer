package com.im.server.mq;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.support.converter.*;

import java.io.IOException;

public class PersistentJsonMessageConverter extends AbstractJsonMessageConverter {
    private static Log log = LogFactory.getLog(Jackson2JsonMessageConverter.class);

    private ObjectMapper jsonObjectMapper = new ObjectMapper();

    private Jackson2JavaTypeMapper javaTypeMapper = new DefaultJackson2JavaTypeMapper();

    public PersistentJsonMessageConverter() {
        super();
        initializeJsonObjectMapper();
    }

    public Jackson2JavaTypeMapper getJavaTypeMapper() {
        return javaTypeMapper;
    }

    public void setJavaTypeMapper(Jackson2JavaTypeMapper javaTypeMapper) {
        this.javaTypeMapper = javaTypeMapper;
    }

    public void setJsonObjectMapper(ObjectMapper jsonObjectMapper) {
        this.jsonObjectMapper = jsonObjectMapper;
    }

    protected void initializeJsonObjectMapper() {
        jsonObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Override
    public Object fromMessage(Message message) throws MessageConversionException {
        Object content = null;
        MessageProperties properties = message.getMessageProperties();
        if (properties != null) {
            String contentType = properties.getContentType();
            if (contentType != null && contentType.contains("json")) {
                String encoding = properties.getContentEncoding();
                if (encoding == null) {
                    encoding = getDefaultCharset();
                }
                try {

                    if (getClassMapper() == null) {
                        JavaType targetJavaType = getJavaTypeMapper().toJavaType(message.getMessageProperties());
                        content = convertBytesToObject(message.getBody(), encoding, targetJavaType);
                    } else {
                        Class<?> targetClass = getClassMapper().toClass(message.getMessageProperties());
                        content = convertBytesToObject(message.getBody(), encoding, targetClass);
                    }
                } catch (IOException e) {
                    throw new MessageConversionException("Failed to convert Message content", e);
                }
            } else {
                log.warn("Could not convert incoming message with content-type [" + contentType + "]");
            }
        }
        if (content == null) {
            content = message.getBody();
        }
        return content;
    }

    private Object convertBytesToObject(byte[] body, String encoding, JavaType targetJavaType)
            throws JsonParseException, JsonMappingException, IOException {
        String contentAsString = new String(body, encoding);
        return jsonObjectMapper.readValue(contentAsString, targetJavaType);
    }

    private Object convertBytesToObject(byte[] body, String encoding, Class<?> targetClass) throws JsonParseException,
            JsonMappingException, IOException {
        String contentAsString = new String(body, encoding);
        return jsonObjectMapper.readValue(contentAsString, jsonObjectMapper.constructType(targetClass));
    }

    @Override
    protected Message createMessage(Object objectToConvert, MessageProperties messageProperties)
            throws MessageConversionException {
        byte[] bytes = null;
        try {
            String jsonString = jsonObjectMapper.writeValueAsString(objectToConvert);
            bytes = jsonString.getBytes(getDefaultCharset());
        } catch (IOException e) {
            throw new MessageConversionException("Failed to convert Message content", e);
        }
        messageProperties.setContentType(MessageProperties.CONTENT_TYPE_JSON);
        messageProperties.setContentEncoding(getDefaultCharset());
        messageProperties.setDeliveryMode(MessageDeliveryMode.PERSISTENT);
        if (bytes != null) {
            messageProperties.setContentLength(bytes.length);
        }

        if (getClassMapper() == null) {
            getJavaTypeMapper().fromJavaType(jsonObjectMapper.constructType(objectToConvert.getClass()),
                    messageProperties);

        } else {
            getClassMapper().fromClass(objectToConvert.getClass(), messageProperties);

        }

        return new Message(bytes, messageProperties);

    }
}
