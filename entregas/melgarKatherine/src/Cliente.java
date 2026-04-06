public class Cliente {
    private Banco banco; 
    private String nombre;
    private String dni;
    private String direccion;

    private Cuenta[] cuentas;
    private int cantidadCuentas;

    public Cliente() {
        this.cuentas = new Cuenta[10];
        this.cantidadCuentas = 0;
    }

    public void actualizarNombre() {
        Console console = new Console();
        this.nombre = console.readString("Nuevo nombre: ");
    }

    public void mostrar() {
        Console console = new Console();
        console.writeln("Cliente: " + this.nombre + " - DNI: " + this.dni);
        console.writeln("Direccion: " + this.direccion);
        for (int i = 0; i < cantidadCuentas; i++) {
            cuentas[i].mostrarDatosCuenta();
        }
    }

    public void actualizarDni() {
        Console console = new Console();
        this.dni = console.readString("Nuevo DNI: ");
    }

    public void actualizarDireccion() {
        Console console = new Console();
        this.direccion = console.readString("Nueva direccion: ");
    }

    void setDatosPrivados(String nombre, String dni, String direccion) {
        this.nombre = nombre;
        this.dni = dni;
        this.direccion = direccion;
    }

    void agregarCuentaPrivada(Cuenta cuenta) {
        assert cantidadCuentas < cuentas.length : "Limite de cuentas alcanzado";
        this.cuentas[cantidadCuentas] = cuenta;
        this.cantidadCuentas++;
    }
}