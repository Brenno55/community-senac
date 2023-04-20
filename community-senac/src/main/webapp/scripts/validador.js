function validarCadastro() {
    let nome = frmContato.nome.value;
    let email = frmContato.email.value;
    let senha = frmContato.senha.value;

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
    let email = frmContato.email.value;
    let senha = frmContato.senha.value;

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
function validarPerfil() {
    let data_nascimento = frmContato.data_nascimento.value;
    let celular = frmContato.celular.value;
    let cFacul = frmContato.cFacul.value;
    let sexo = frmContato.sexo.value;

    if (data_nascimento === "") {
        alert("Preencha o campo data");
        frmContato.fone.focus()
        return false;
    }
    if (celular === "") {
            alert("Preencha o campo celular");
            frmContato.fone.focus()
            return false;
    }
    if (cFacul === "") {
            alert("Preencha o campo curso");
            frmContato.fone.focus()
            return false;
    }
    if (sexo === "") {
            alert("Preencha o campo sexo");
            frmContato.fone.focus()
            return false;
    }

    document.forms["frmContato"].submit()
}