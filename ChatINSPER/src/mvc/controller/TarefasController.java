package mvc.controller;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import mvc.model.Mensagem;
import mvc.model.Tarefa;
import mvc.model.TarefaDAO;
import mvc.model.UsuarioDAO;

@Controller
public class TarefasController {
    
    @RequestMapping("adicionaMensagem")
    public String adicionaMensagem(Mensagem mensagem, HttpSession session) {
    	System.out.println(mensagem.getMensagem());
    	mensagem.setUsuario((String) session.getAttribute("usuarioLogado"));
    	TarefaDAO dao = new TarefaDAO();
    	dao.adicionaMensagem(mensagem);
    	dao.close();
    	return "redirect:telaChat";
    }
    
    @RequestMapping("telaDeMenu")
    public String telaDeMenu(){
    	return "menu";
    }
    
    @RequestMapping("telaChat")
    public String listaDeMensagem(){
    	return "chat";
    }
    
    @RequestMapping("mensagensJquery")
    public String listaDeMensagensJquery(Model model){
    	TarefaDAO dao = new TarefaDAO();
    	model.addAttribute("messages",dao.getListaMensagem());
    	dao.close();
    	return "mensagens";
    }

  }