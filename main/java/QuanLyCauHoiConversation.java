public class QuanLyCauHoiConversation extends QuanLyCauHoi{
    public QuanLyCauHoiConversation() {
    }

    @Override
    public void xemDanhSachCauHoi() {
        this.danhSachCauHoi.stream().filter(conversation -> conversation instanceof Conversation)
                .forEach(conversation-> System.out.println(conversation.toString()));
    }

    public void timCauHoi(String noiDungDoanVan){
        this.danhSachCauHoi.stream().filter(conversation -> conversation instanceof Conversation)
                .filter(conversation -> ((Conversation)conversation).getDoanVan().getNoiDung()
                        .contains(noiDungDoanVan)).forEach(conversation -> System.out.println(conversation.toString()));
    }

    public void timCauHoi(MucDo mucDo){
        this.danhSachCauHoi.stream().filter(conversation -> conversation instanceof Conversation)
                .filter(conversation -> conversation.getMucDo() == mucDo)
                .forEach(conversation -> System.out.println(conversation .toString()));
    }

}
