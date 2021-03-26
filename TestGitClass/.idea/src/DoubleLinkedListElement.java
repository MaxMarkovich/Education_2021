public class DoubleLinkedListElement<L>{
    L data;
    DoubleLinkedListElement<L>  next;
    DoubleLinkedListElement<L> prev;
    public DoubleLinkedListElement(L data, DoubleLinkedListElement<L> next, DoubleLinkedListElement<L> prev){
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
    public DoubleLinkedListElement<L> getNextElement(){
        return next;
    }
    public DoubleLinkedListElement<L> getPrevElement(){
        return prev;
    }
    public void setNextElement(DoubleLinkedListElement<L> next){
        this.next = next;
    }
    public void setPrevElement(){
        this.prev = prev;
    }
    public L getData(){
        return data;
    }

}
