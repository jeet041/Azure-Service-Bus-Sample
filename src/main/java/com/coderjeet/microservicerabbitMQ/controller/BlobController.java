/*
package com.coderjeet.microservicerabbitMQ.controller;


import com.azure.spring.cloud.core.resource.AzureStorageBlobProtocolResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.WritableResource;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/blob")
public class BlobController {


    private static final Logger logger = LoggerFactory.getLogger(BlobController.class);
    private final String containerName;
    private final ResourceLoader resourceLoader;
    private final AzureStorageBlobProtocolResolver azureStorageBlobProtocolResolver;
    static final String BLOB_RESOURCE_PATTERN = "azure-blob://%s/%s";

    @Value("${spring.cloud.azure.storage.blob.account-name}")
    private String accountName;
    @Value("${spring.cloud.azure.storage.blob.endpoint}")
    private String endpoint;

    public BlobController(@Value("${spring.cloud.azure.storage.blob.container-name}") String containerName,
                          ResourceLoader resourceLoader,
                          AzureStorageBlobProtocolResolver patternResolver) {
        this.containerName = containerName;
        this.resourceLoader = resourceLoader;
        this.azureStorageBlobProtocolResolver = patternResolver;
    }

    */
/**
     * Using AzureStorageBlobProtocolResolver to get Azure Storage Blob resources with file pattern.
     *
     * @return fileNames in the container match pattern: *.txt
     *//*

    @GetMapping("/getFiles")
    public List<String> listTxtFiles() throws IOException {
        Resource[] resources = azureStorageBlobProtocolResolver.getResources(String.format(BLOB_RESOURCE_PATTERN, this.containerName, "*.txt"));
        logger.info("{} resources founded with pattern:*.txt",resources.length);
        return Stream.of(resources).map(Resource::getFilename).collect(Collectors.toList());
    }

    @GetMapping("/{fileName}")
    public String readResource(@PathVariable("fileName") String fileName) throws IOException {
        logger.info("Account name:{}",accountName);
        Resource resource = resourceLoader.getResource(String.format(BLOB_RESOURCE_PATTERN, this.containerName, fileName));
        return StreamUtils.copyToString(resource.getInputStream(), Charset.defaultCharset());
    }

    @PostMapping("/{fileName}")
    public String writeResource(@PathVariable("fileName") String fileName, @RequestBody String data) throws IOException {
        logger.info("ENDPOINT name:{}",endpoint);
        Resource resource = resourceLoader.getResource(String.format(BLOB_RESOURCE_PATTERN, this.containerName, fileName));
        try (OutputStream os = ((WritableResource) resource).getOutputStream()) {
            os.write(data.getBytes());
        }
        return "blob was updated";
    }
}
*/
