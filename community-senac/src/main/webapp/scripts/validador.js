function validarCadastro() {
    let nome = frmContato.nome.value;
    let email = frmContato.email.value;
    let senha = frmContato.senha.value;
    let count = frmContato.count.value;

    if (!email.endsWith("@senacsp.edu.br")) {
        alert("O email deve pertencer ao domínio @senacsp.edu.br");
        return false;
    }

    if (count == 1) {
            alert("Email já existe.");
            frmContato.email.focus();

            count = 0;
            return false;
    }

    if (nome === "") {
        alert("Preencha o campo Nome");
        frmContato.nome.focus()
        return false;
    }

    if (email === "") {
        alert("Preencha o campo email");
        frmContato.fone.focus()
        return false;
    }

    if (senha === "") {
            alert("Preencha o campo senha");
            frmContato.fone.focus()
            return false;
    }
    document.forms["frmContato"].submit()
}

function validarLogin() {
  var inputs = document.getElementsByTagName("input");

  for (var i = 0; i < inputs.length; i++) {
    if (inputs[i].value === "") {
      alert("Por favor, preencha todos os campos.");
      return false;
        }
    }

    document.forms["frmContato"].submit()
}

function validarPerfil() {

  var inputs = document.getElementsByTagName("input");
  var selects = document.getElementsByTagName("select");
  for (var i = 0; i < inputs.length; i++) {
    if (inputs[i].value === "") {
      alert("Por favor, preencha todos os campos.");
      return false;
    }
  }
  for (var j = 0; j < selects.length; j++) {
    if (selects[j].value === "") {
      alert("Por favor, selecione uma opção em todos os campos.");
      return false;
    }
  }
  return true;
}