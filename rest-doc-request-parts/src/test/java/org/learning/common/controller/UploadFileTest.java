package org.learning.common.controller;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.learning.LearningApplication;
import org.learning.common.support.FileUploader;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.restdocs.RestDocumentation;
import org.springframework.restdocs.mockmvc.RestDocumentationResultHandler;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.learning.common.parts.RequestPartsDocumentation.partWithName;
import static org.learning.common.parts.RequestPartsDocumentation.requestParts;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Lingfeng on 2016/5/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(LearningApplication.class)
@WebAppConfiguration
public class UploadFileTest {

    @Rule
    public final RestDocumentation restDocumentation = new RestDocumentation("build/generated-snippets");

    protected RestDocumentationResultHandler document;

    private MockMvc mockMvc;

    @InjectMocks
    private FileController fileController;

    @Mock
    private FileUploader fileUploader;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        this.document = document("{method-name}", preprocessRequest(prettyPrint()), preprocessResponse(prettyPrint()));
        this.mockMvc = MockMvcBuilders.standaloneSetup(fileController)
                .apply(documentationConfiguration(this.restDocumentation)
                        .uris().withScheme("https")
                        .withHost("www.learning.com")
                        .withPort(443))
                .alwaysDo(this.document)
                .build();
    }

    @Test
    public void uploadFile() throws Exception {
        when(fileUploader.uploadFile(anyString(), any())).thenReturn(
                "http://o701fmjvo.bkt.clouddn.com/1-12345654321-BL.jpg");

        MockMultipartFile imageFile = new MockMultipartFile("file", "filename.jpg",
                "text/plain", "some image".getBytes());

        document.snippets(
                requestParts(
                        partWithName("file").description("上传的文件")
                )
        );

        mockMvc.perform(fileUpload("/api/files")
                        .file(imageFile)
        ).andExpect(status().isOk());
    }
}
