package tw.edu.ncu.cc.activity.server.controller

import specification.IntegrationSpecification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

class AnnounceControllerTest extends IntegrationSpecification {

    def "it can provide latest undisabled COMMON Announces"() {
        when:
            def response = JSON( server()
                .perform( get( "/v1/announce/common/10" ).accept( "application/json" ) )
                .andExpect( status().isOk() )
                .andReturn()
            );
        then:
            response.contains( JSON(
                    '''
                    {
                        "title"   : "title2",
                        "content" : "content2",
                        "attachment" : "prefix/file2",
                        "time" : "2013-08-01 08:23"
                    }
                    '''
            ) )
    }

    def "it can provide latest undisabled GROUP Announces"() {
        when:
            def response = JSON( server()
                    .perform( get( "/v1/announce/group/10" ).accept( "application/json" ) )
                    .andExpect( status().isOk() )
                    .andReturn()
            );
        then:
            response.contains( JSON(
                    '''
                    {
                        "title"   : "title1",
                        "content" : "content1",
                        "attachment" : "prefix/file1",
                        "time" : "2013-07-31 08:23"
                    }
                    '''
            ) )
            response.contains( JSON(
                    '''
                    {
                        "title"   : "title4",
                        "content" : "content4",
                        "attachment" : null,
                        "time" : "2013-08-03 08:23"
                    }
                    '''
            ) )
    }

}

