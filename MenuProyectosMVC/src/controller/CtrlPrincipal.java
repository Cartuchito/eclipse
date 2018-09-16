package controller;

public class CtrlPrincipal {

	public static void iniciaApp() {
		new view.FrmPrincipal();
	}

	public static void opcProyectos() {
		controller.CtrlProyectos.inicio();
	}

	public static void opcTrabajadores() {
		controller.CtrlTrabajadores.inicio();
	}

	public static void opcEquipos() {
		controller.CtrlEquipos.inicio();
	}

}