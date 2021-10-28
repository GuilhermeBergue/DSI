package br.edu.ifsp;

public class Calculator {

    private static Calculator sCalculadora = null;
    private float memoria;
    private int operacao;

    private Calculator() {
        c();
    }

    public static Calculator getInstance() {
        if(sCalculadora == null){
            sCalculadora = new Calculator();
        }
        return sCalculadora;
    }

    public void c(){
        memoria = 0;
        operacao = Constants.NULO;
    }

    public float calcular(int operacao, float valor) {
        if (this.operacao == Constants.NULO) {
            this.operacao = operacao;
            this.memoria = valor;
        } else {
            switch (operacao) {
                case Constants.ADICAO:
                    memoria += valor;
                    break;
                case Constants.SUBTRACAO:
                    memoria -= valor;
                    break;
                case Constants.MULTIPLICACAO:
                    memoria *= valor;
                    break;
                case Constants.DIVISAO:
                    memoria /= valor;
                    break;
                case Constants.POTENCIA:
                    memoria = (float) Math.pow(memoria, valor);
                    break;
                default:
                    break;
            }
            this.operacao = operacao;
        }
        return memoria;
    }
}
