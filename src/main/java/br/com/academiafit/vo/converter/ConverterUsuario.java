package br.com.academiafit.vo.converter;

import java.util.ArrayList;
import java.util.List;

import br.com.academiafit.entidade.Usuario;
import br.com.academiafit.vo.UsuarioVO;


public class ConverterUsuario {
	public static Usuario ConverterUsuarioVoParaUsuario(UsuarioVO usuarioVO){
		Usuario usuario = new Usuario();
		
		usuario.setNickname(usuarioVO.getNickname());
		usuario.setSenha(usuarioVO.getSenha());
		return usuario;
	}
	
	public static UsuarioVO ConverterUsuarioUsuarioParaVO(Usuario usuario){
		UsuarioVO usuarioVo = new UsuarioVO();
		
		usuarioVo.setNickname(usuario.getNickname());
		usuarioVo.setSenha(usuario.getSenha());
		return usuarioVo;
	}
	
	public static List<UsuarioVO> ConverterUsuarioListaUsuarioParaListaVo(List<Usuario> listaEntidade){
		
		List<UsuarioVO> listUsuarioVO = new ArrayList<UsuarioVO>();
		if(listaEntidade != null && !listaEntidade.isEmpty()){
			for(Usuario usuario : listaEntidade){
				UsuarioVO usuarioVO = ConverterUsuarioUsuarioParaVO(usuario);
				listUsuarioVO.add(usuarioVO);
			}
		}
		return listUsuarioVO;
	}
}
