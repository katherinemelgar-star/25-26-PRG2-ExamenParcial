public class Cuenta {
    private String numeroIBAN;
    private double saldo;
    private String tipoCuenta;

    private String[] historialMovimientos;
    private int cantidadMovimientos;

    public Cuenta() {
        this.historialMovimientos = new String[100];
        this.cantidadMovimientos = 0;
    }

    public void movimientos(double cantidad, String fecha) {
        Console console = new Console();
        console.writeln("Movimientos de " + this.numeroIBAN + ":");
        for (int i = 0; i < cantidadMovimientos; i++) {
            console.writeln(historialMovimientos[i]);
        }
    }

    public void ingresos(double cantidad, String fecha) {
        assert cantidad > 0 : "El ingreso debe ser positivo";
        this.saldo = this.saldo + cantidad;
        this.registrarMovimientoPrivado("Ingreso de " + cantidad + " el " + fecha);
    }

    public void retiradas(double cantidad, String fecha) {
        assert cantidad > 0 : "La cantidad a retirardebe ser positiva";
        assert cantidad <= this.saldo : "Saldo insuficiente";
        this.saldo = this.saldo - cantidad;
        this.registrarMovimientoPrivado("Retirada de " + cantidad + " el " + fecha);
    }

    public void transferencias(double cantidad, String fecha) {
        assert cantidad > 0 : "La transferencia debe ser positiva";
        assert cantidad <= this.saldo : "Saldo insuficiente";
        
        this.saldo = this.saldo - cantidad;
        this.registrarMovimientoPrivado("Transferencia de " + cantidad + " el " + fecha);
    }

    private void registrarMovimientoPrivado(String detalle) {
        assert cantidadMovimientos < historialMovimientos.length : "Historial lleno";
        this.historialMovimientos[cantidadMovimientos] = detalle;
        this.cantidadMovimientos++;
    }

    void setDatosPrivados(String iban, double saldoInicial, String tipo) {
        this.numeroIBAN = iban;
        this.saldo = saldoInicial;
        this.tipoCuenta = tipo;
    }

    void mostrarDatosCuenta() {
        Console console = new Console();
        console.writeln("IBAN: " + this.numeroIBAN + " | Saldo: " + this.saldo + " | Tipo: " + this.tipoCuenta);
    }
}