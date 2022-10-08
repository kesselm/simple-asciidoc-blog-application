package de.kessel.elena.config;

import de.kessel.elena.entity.PostBlog;
import de.kessel.elena.service.PostBlogService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class DataInstaller implements CommandLineRunner {

    private final PostBlogService postBlogService;

    public DataInstaller(final PostBlogService postBlogService) {
        this.postBlogService = postBlogService;
    }

    @Override
    public void run(String... args) throws Exception {
        List<PostBlog> postBlogs = List.of(
                createPostBlog(asciidocListen()),
                createPostBlog(asciidocChecklisten()),
                createPostBlog(asciidocAufzaehlung()),
                createPostBlog(asciidocLabeledLists()),
                createPostBlog(ascdiidocQuotes()),
                createPostBlog(asciidocBlock()),
                createPostBlog(asccidocCodeBlocksWithCallouts()),
                createPostBlog(asciidocTable()),
                createPostBlog(loreIpsum()),
                createPostBlog(asciidocMath()),
                createPostBlog(asciidocSourceCode()),
                createPostBlog(asciidocUnconstrainedText()),
                createPostBlog(asciidocHighlightedText()),
                createPostBlog(asciidocSupscriptedText()),
                createPostBlog(asciidocQuote()),
                createPostBlog(ascdiidocQuotes())
        );

        postBlogService.savePostBlogs(postBlogs);
    }

    private PostBlog createPostBlog(final String text){
        PostBlog postBlog = new PostBlog();
        postBlog.setCreatedAt(LocalDate.now());
        postBlog.setUpdatedAt(LocalDate.now());
        postBlog.setText(text);
        return postBlog;
    }

    private String asciidocListen() {
        return """
                == Listen
               
                * Element
                ** nächstes Element
                * weiteres Element
                """;
    }

    private String asciidocChecklisten() {
        return """
                == Checklisten
                                
                - [ ] noch nicht erledigt
                - [*] erledigt
                """;
    }

    private String asciidocAufzaehlung() {
        return """
                == Aufzählung
                                
                . erstes Element
                . zweites Element
                .. erstes Unterelement
                """;
    }

    private String asciidocLabeledLists() {
        return """
                == Labeled Lists
                                
                Label:: Beschreibung
                noch ein Label:: eine weitere Beschreibung
                """;
    }

    private String asciidocQuote() {
        return """
                == Quote
                                
                [quote, Bill Gates, Microsoft]
                ____
                640 KB are enough for everyone.
                ____
                """;
    }

    private String asciidocBlock() {
        return """
                == Literal Block
                ....
                Jetzt wird alles
                    wie angegeben
                  - ausgegeben.
                """;
    }

    private String asccidocCodeBlocksWithCallouts() {
        return """
                == Code Block
                                
                [source,java]
                ----
                public class EnterpriseAbstractFactory { <1>
                     public doSomething(int howLong) {
                            Thread.sleep(howLong);   <2>
                     }
                }
                ----
                                
                <1> to short
                <2> busy waiting pleas
                """;
    }

    private String asciidocTable() {
        return """
                == Table
                                
                [cols="1,1"]
                |===
                |Cell in column 1, header row |Cell in column 2, header row
                                
                |Cell in column 1, row 2
                |Cell in column 2, row 2
                                
                |Cell in column 1, row 3
                |Cell in column 2, row 3
                                
                |Cell in column 1, row 4
                |Cell in column 2, row 4
                |===
                """;
    }

    private String loreIpsum() {
        return """
                == Lore Ipsum
                
                Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum.
                Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam
                erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing
                elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus
                est Lorem ipsum dolor sit amet.;
                        
                Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum 
                zzril delenit augue duis dolore te feugait nulla facilisi. Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.
                Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie 
                consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi.
                Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim placerat facer possim assum. Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy 
                nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat.
                Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis.
                At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, 
                sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata 
                sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, At accusam aliquyam diam diam dolore dolores duo eirmod eos erat, et nonumy sed tempor et et invidunt 
                justo labore Stet clita ea et gubergren, kasd magna no rebum. sanctus sea sed takimata ut vero voluptua. est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, 
                sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat.
                Consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd 
                gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, 
                sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur 
                sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, 
                no sea takimata sanctus.
                Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. 
                tet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna 
                aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, 
                consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd 
                gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.
                Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent 
                luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat 
                volutpat.
                """;
    }

    private String asciidocMath() {
        return """
                == Math
                
                Here is an example, latexmath:[e^{i \\pi} + 1 = 0].
                                                                          
                [latexmath]
                ++++
                \\frac{\\partial V}{\\partial t}
                + \\frac{1}{2} \\sigma^2 S^2 \\frac{\\partial^2 V}{\\partial S^2}
                + r S \\frac{\\partial V}{\\partial S}
                - r V = 0
                ++++
                                
                """;
    }

    private String asciidocSourceCode() {
        return """
                .Optional Title
                [source,java]
                ----
                public void main(String[] args) throws Exception {
                    System.out.println("Hello World!")
                }
                ----
                """;
    }

    private String asciidocUnstainedText() {
        return """
                It has *strong* significance to me.

                I _cannot_ stress this enough.

                Type `OK` to accept.

                That *_really_* has to go.

                Can't pick one? Let's use them `*_all_*`.
                """;
    }

    private String asciidocUnconstrainedText() {
        return """
                **C**reate, **R**ead, **U**pdate, and **D**elete (CRUD)

                That's fan__freakin__tastic!

                Don't pass generic ``Object``s to methods that accept ``String``s!

                It was Beatle**__mania__**!
                """;
    }

    private String asciidocHighlightedText() {
        return """
                Werewolves are allergic to #cinnamon#.

                ##Mark##up refers to text that contains formatting ##mark##s.

                Where did all the [.underline]#cores# go?

                We need [.line-through]#ten# twenty VMs.

                A [.myrole]#custom role# must be fulfilled by the theme.
                """;
    }

    private String asciidocSupscriptedText() {
        return """
                  ^super^script phrase

                  ~sub~script phrase
                """;
    }

    private String ascdiidocQuotes() {
        return """
                 "`double curved quotes`"

                 '`single curved quotes`'

                 Olaf's desk was a mess.

                 A ``std::vector```'s size is the number of items it contains.

                 All of the werewolves`' desks were a mess.

                 Olaf had been with the company since the `'00s.
                """;
    }
}
