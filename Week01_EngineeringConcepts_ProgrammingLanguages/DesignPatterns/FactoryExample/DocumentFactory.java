public abstract class DocumentFactory {

    // Factory method - subclasses decide which Document to instantiate
    public abstract Document createDocument();

    // Optional: common logic that uses the factory method
    public Document getDocument() {
        Document doc = createDocument();
        doc.open();
        return doc;
    }
}