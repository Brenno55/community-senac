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