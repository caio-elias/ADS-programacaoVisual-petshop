
package view;



public class AuxConta {
    int valorAgendamento;
    int valorItem;

    public AuxConta() {
    }

    public AuxConta(int valorAgendamento, int valorItem) {
        this.valorAgendamento = valorAgendamento;
        this.valorItem = valorItem;
    }
    

    public int getValorAgendamento() {
        return valorAgendamento;
    }

    public int getValorItem() {
        return valorItem;
    }

    public void setValorAgendamento(int valorAgendamento) {
        this.valorAgendamento = valorAgendamento;
    }

    public void setValorItem(int valorItem) {
        this.valorItem = valorItem;
    }
    
}
