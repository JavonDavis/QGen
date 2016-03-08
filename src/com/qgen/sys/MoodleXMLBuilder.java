package com.qgen.sys;

/**
 * Created by javon on 07/03/2016.
 */
public class MoodleXMLBuilder {

    private StringBuilder builder;

    public MoodleXMLBuilder() {
        setup();
    }

    private void setup() {
        builder = new StringBuilder();
        builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        builder.append("<quiz>\n" +
                "<!-- question: 0  -->\n" +
                "  <question type=\"category\">\n" +
                "    <category>\n" +
                "        <text>Generated by QGen</text>\n" +
                "\n" +
                "    </category>\n" +
                "  </question>\n");
    }

    public MoodleXMLBuilder addQuestion(MoodleXMLQuestion question)
    {
        builder.append(question.toString());
        return this;
    }

    public String toString()
    {
        builder.append("</quiz>");
        return builder.toString();
    }

    public static class MoodleXMLQuestion
    {
        private StringBuilder qBuilder;
        private String name;
        private String text;
        private String type;


        public MoodleXMLQuestion(String name, String text, String type) {
            this.name = name;
            this.text = text;
            this.type = type;
            setup();
        }

        private void setup()
        {
            qBuilder = new StringBuilder();
            qBuilder.append("\n\t<question type=\""+type+"\">");
            qBuilder.append("<name>\n" + "      <text>").append(name).append("</text>\n").append("    </name>");
            qBuilder.append("<questiontext format=\"html\">\n" + "      <text>").append(text).append("</text>\n").append("    </questiontext>");
            qBuilder.append("<generalfeedback format=\"html\">\n" +
                    "      <text></text>\n" +
                    "    </generalfeedback>\n" +
                    "    <defaultgrade>1.0000000</defaultgrade>\n" +
                    "    <penalty>0.1000000</penalty>\n" +
                    "    <hidden>0</hidden>\n" +
                    "    <single>true</single>\n" +
                    "    <shuffleanswers>true</shuffleanswers>\n" +
                    "    <answernumbering>abc</answernumbering>\n" +
                    "    <correctfeedback format=\"html\">\n" +
                    "      <text></text>\n" +
                    "    </correctfeedback>\n" +
                    "    <partiallycorrectfeedback format=\"html\">\n" +
                    "      <text></text>\n" +
                    "    </partiallycorrectfeedback>\n" +
                    "    <incorrectfeedback format=\"html\">\n" +
                    "      <text></text>\n" +
                    "    </incorrectfeedback>");
        }

        public MoodleXMLQuestion addAnswer(MoodleXMLAnswer answer)
        {
            qBuilder.append(answer.toString());
            return this;
        }

        public String toString()
        {
            qBuilder.append("  </question>\n");
            return qBuilder.toString();
        }
    }

    public static class MoodleXMLAnswer
    {
        private StringBuilder aBuilder;

        public MoodleXMLAnswer(String text)
        {
            aBuilder = new StringBuilder();
            aBuilder.append("\n\t\t<answer fraction=\"0\" format=\"moodle_auto_format\">\n" + "      <text>")
                    .append(text)
                    .append("</text>\n")
                    .append("      <feedback format=\"html\">\n")
                    .append("        <text></text>\n")
                    .append("      </feedback>\n")
                    .append("    </answer>\n");
        }

        public String toString()
        {
            return aBuilder.toString();
        }
    }
}
