package com.sistemapizzeria_local;


import Negocio.BO.IClienteBO;
import Negocio.BO.IDomicilioBO;
import Negocio.BO.IPizzaBO;
import Negocio.BO.ITelefonoBO;
import Negocio.DTO.ClienteDTO;
import Negocio.DTO.DomicilioDTO;
import Negocio.DTO.PizzaDTO;
import Negocio.DTO.TelefonoDTO;
import Negocio.fabrica.FabricaBO;
import Persistencia.Dominio.EstadoCliente;
import java.time.LocalDate;
import java.util.ArrayList;
import negocio.excepciones.NegocioException;

/**
 *
 * @author Andre
 */
public class SistemaPizzeria_Local {

    public static void main(String[] args) throws NegocioException {
        
        //==OBTIENE BO DE FÁBRICA==
        IClienteBO clienteBO = FabricaBO.clienteBO();
        IPizzaBO pizzaBO = FabricaBO.pizzaBO();
        
        
        
        
        
        
        
        ClienteDTO cliente1 = new ClienteDTO();

        //Cliente
        cliente1.setId(1);
        cliente1.setNombres("Gamma");
        cliente1.setApellidoPaterno("Chiquis");
        cliente1.setApellidoMaterno("López");
        cliente1.setContrasenia("CONTRA!");
        cliente1.setNombreUsuario("andre.garcia");
        cliente1.setTipo("hola");
        cliente1.setCorreo("correo@gmail.com");
        cliente1.setFechaNacimiento(LocalDate.of(1995, 5, 15));
        cliente1.setEstado(EstadoCliente.ACTIVO);

        //Domicilio DTO
        DomicilioDTO domicilio = new DomicilioDTO();
        domicilio.setCalle("Callelandia");
        domicilio.setNumero("123");
        domicilio.setColonia("MENCHACA");
        domicilio.setCodigoPostal("85000");
        cliente1.setDomicilio(domicilio);

        //Lista de Teléfonos DTO
        TelefonoDTO telefono = new TelefonoDTO();
        telefono.setNumero("5512345678");
        telefono.setEtiqueta("Celular");
        cliente1.agregarTelefono(telefono);
         
        
        
        
        
        
        //==ACCIONES CRUD==
        //Agrega el cliente a la BD
        //clienteBO.agregarCliente(clienteDTO);
        
        //Consulta cliente agregado
        ClienteDTO clienteConsultado = clienteBO.consultarCliente(4);
        System.out.println("Si se consultó el cliente 1 vas a ver esto: " + clienteConsultado);
        
        //Actualiza cliente 1 con otro cliente
        ClienteDTO clienteActualizado = clienteBO.actualizarCliente(cliente1);
        System.out.println("Si se actualizó el cliente1 vas a ver esto: " + clienteActualizado);
        
        ArrayList<PizzaDTO> pizzas = pizzaBO.consultarPizzas();
        System.out.println("Pizzas encontradas: " + pizzas);
    }
}
