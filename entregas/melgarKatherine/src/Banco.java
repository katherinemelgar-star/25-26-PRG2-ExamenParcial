public class Banco{
    private String nombreBanco;
    private Cliente[] clientes;
    private int cantidadClientes;

    public Banco() {
        this.nombreBanco = "Banco Central";
        this.clientes = new Cliente[100]; 
        this.cantidadClientes = 0;
        this.iniciarEscenario();
    }

    private void iniciarEscenario() {
        Cliente ana = new Cliente();
        ana.setDatosPrivados("Ana Garcia", "12345678A", "Madrid");
        Cuenta cuentaAna1 = new Cuenta();
        cuentaAna1.setDatosPrivados("ES91 1234 5678 9012 3456", 5000, "Nomina");
        Cuenta cuentaAna2 = new Cuenta();
        cuentaAna2.setDatosPrivados("ES91 5555 6666 7777 8888", 10000, "Premium");
        ana.agregarCuentaPrivada(cuentaAna1);
        ana.agregarCuentaPrivada(cuentaAna2);

        Cliente juan = new Cliente();
        juan.setDatosPrivados("Juan Perez", "87654321B", "Barcelona");
        Cuenta cuentaJuan = new Cuenta();
        cuentaJuan.setDatosPrivados("ES91 9876 5432 1098 7654", 3000, "Estandar");
        juan.agregarCuentaPrivada(cuentaJuan);

        this.clientes[0] = ana;
        this.clientes[1] = juan;
        this.cantidadClientes = 2;

        cuentaAna1.ingresos(1000, "01/03/2025");
        cuentaJuan.retiradas(200, "02/03/2025");
        cuentaAna2.transferencias(500, "03/03/2025");
    }
}