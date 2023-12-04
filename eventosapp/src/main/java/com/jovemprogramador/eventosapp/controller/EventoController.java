package com.jovemprogramador.eventosapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

// import com.jovemprogramador.eventosapp.models.Categoria;
import com.jovemprogramador.eventosapp.models.Convidado;
import com.jovemprogramador.eventosapp.models.Evento;
// import com.jovemprogramador.eventosapp.models.Usuario;
// import com.jovemprogramador.eventosapp.models.UsuariosRoles;
// import com.jovemprogramador.eventosapp.repository.CategoriaRepository;
import com.jovemprogramador.eventosapp.repository.ConvidadoRepository;
import com.jovemprogramador.eventosapp.repository.EventoRepository;
// import com.jovemprogramador.eventosapp.repository.UsuarioRepository;
// import com.jovemprogramador.eventosapp.repository.UsuariosRolesRepository;

import jakarta.validation.Valid;

@Controller
public class EventoController {

	@Autowired
	private EventoRepository er;
	@Autowired
	private ConvidadoRepository cr;
	// @Autowired
	// private CategoriaRepository catr;
	// @Autowired
	// private UsuarioRepository ur;
	// @Autowired
	// private UsuariosRolesRepository urr;

	@RequestMapping(value = "/cadastrarEvento", method = RequestMethod.GET)
	public String form() {
		return "evento/formEvento";
	}

	@RequestMapping(value = "/cadastrarEvento", method = RequestMethod.POST)
	public String form(@Valid Evento evento, BindingResult result,
			RedirectAttributes attributes) {

		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/cadastrarEvento";
		}
		er.save(evento);
		attributes.addFlashAttribute("mensagem", "Evento adicionado com sucesso!");
		return "redirect:/cadastrarEvento";
	}

	// @RequestMapping(value = "/cadastrarUsuario", method = RequestMethod.GET)
	// public String formUsuario() {
	// return "evento/formUsuario";
	// }

	// @RequestMapping(value = "/cadastrarUsuario", method = RequestMethod.POST)
	// public String formUsuarioPost(@Valid Usuario usuario, BindingResult result,
	// RedirectAttributes attributes) {

	// Usuario usuarioCadastrado;
	// // UsuariosRoles usRoles = new UsuariosRoles();

	// if (result.hasErrors()) {
	// attributes.addFlashAttribute("mensagem", "Verifique os campos!");
	// return "redirect:/cadastrarUsuario";
	// }
	// // System.out.println(result.getFieldValue("senha"));
	// // System.out.println(result.getFieldValue("repitasenha"));

	// usuarioCadastrado = ur.findBylogin(usuario.getLogin()); // verifica se o
	// login já existe cadastrado

	// if (usuarioCadastrado != null) {
	// attributes.addFlashAttribute("mensagem", "Login já cadastrado!");
	// return "redirect:/cadastrarUsuario";

	// } else {

	// if (usuario.getSenha().equals(result.getFieldValue("repitasenha"))) {
	// usuario.setSenha(geraCriptografia(usuario.getSenha()));
	// ur.save(usuario);
	// usuarioCadastrado = ur.findBylogin(usuario.getLogin()); // pega o login que
	// acabou de cadastrar
	// // para cadastrar a role
	// // usRoles.setUsuario_id(usuarioCadastrado.getLogin());
	// // usRoles.setRole_id("ROLE_USER");
	// // urr.save(usRoles);

	// attributes.addFlashAttribute("mensagem", "Usuario adicionado com sucesso!");
	// return "redirect:/cadastrarUsuario";

	// } else {
	// attributes.addFlashAttribute("mensagem", "As senha precisam ser iguais");
	// return "redirect:/cadastrarUsuario";
	// }
	// }

	// }

	@RequestMapping("/eventos")
	public ModelAndView listaEventos() {
		ModelAndView mv = new ModelAndView("evento/listaEvento");
		Iterable<Evento> eventos = er.findAll();
		mv.addObject("leventos", eventos); // leventos atributo que está no HTML
		return mv;
	}

	@RequestMapping(value = "/{codigo}", method = RequestMethod.GET)
	public ModelAndView detalhesEvento(@PathVariable("codigo") long codigo) {
		Evento evento = er.findByCodigo(codigo);
		ModelAndView mv = new ModelAndView("evento/detalhesEvento");
		// mv.addObject("deventos", evento);
		mv.addObject(evento);

		Iterable<Convidado> convidados = cr.findByEvento(evento);
		mv.addObject("convidados", convidados);

		return mv;
	}

	@RequestMapping(value = "/{codigo}", method = RequestMethod.POST)
	public String detalhesEventoPost(@PathVariable("codigo") long codigo,
			@Valid Convidado convidado,
			BindingResult result,
			RedirectAttributes attributes) {

		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/{codigo}";
		}
		Evento evento = er.findByCodigo(codigo);
		convidado.setEvento(evento);
		cr.save(convidado);

		attributes.addFlashAttribute("mensagem", "Convidado adicionado com sucesso!");
		return "redirect:/{codigo}";
	}

	@RequestMapping("/deletarEvento")
	public String deletarEvento(long codigo) {
		Evento evento = er.findByCodigo(codigo);
		er.delete(evento);
		return "redirect:/eventos";

	}

	@RequestMapping("/deletarConvidado")
	public String deletarConvidado(String rg) {

		Convidado convidado = cr.findByRg(rg);
		cr.delete(convidado);
		Evento evento = convidado.getEvento();
		long codEvento = evento.getCodigo();

		return "redirect:/" + codEvento;

	}

	@RequestMapping("/editarEvento")
	public ModelAndView editarEvento(long codigo) {

		Evento evento = er.findByCodigo(codigo);
		ModelAndView mv = new ModelAndView("evento/editarEvento");

		mv.addObject(evento);

		return mv;

	}

	// METODO QUE EDITA O EVENTO
	@RequestMapping(value = "/editarEvento", method = RequestMethod.POST)
	public String editarEventoPost(Evento evento) {

		er.save(evento);
		return "redirect:/eventos";
	}

	@RequestMapping(value = "editarConvidado/{codigo}/{rg}", method = RequestMethod.GET)
	public ModelAndView editarConvidado(@PathVariable("codigo") long codigo,
			@PathVariable("rg") String rg) {
		Evento evento = er.findByCodigo(codigo);
		Convidado convidado = cr.findByRg(rg);
		ModelAndView mv = new ModelAndView("evento/editaConvidado");
		mv.addObject(evento);
		mv.addObject(convidado);

		return mv;
	}

	@RequestMapping(value = "editarConvidado/{codigo}/{rg}", method = RequestMethod.POST)
	public String editarConvidadoPost(@PathVariable("codigo") long codigo,
			@PathVariable("rg") String rg, Convidado convidado) {
		Evento evento = er.findByCodigo(codigo);
		convidado.setEvento(evento);
		cr.save(convidado);

		return "redirect:/{codigo}";
	}

	// @RequestMapping(value ="/categoriaEvento",method= RequestMethod.GET)
	// public String formCategoria(){
	// return "evento/formCategoria";
	// }

	// @RequestMapping(value ="/categoriaEvento",method= RequestMethod.POST)
	// public String formCategoria(@RequestParam("cat") List<String> cats){

	// Categoria categoria;
	// for(int i = 0; i < cats.size(); i++) {
	// System.out.printf("%s, " , cats.get(i));
	// categoria = new Categoria();
	// categoria.setNomeCategoria(cats.get(i));
	// catr.save(categoria);
	// }

	// //er.save(evento);
	// return "redirect:/eventos";
	// }

	// private String geraCriptografia(String senha) {

	// String senhaCripto = new BCryptPasswordEncoder().encode(senha);
	// return senhaCripto;

	// }
}
