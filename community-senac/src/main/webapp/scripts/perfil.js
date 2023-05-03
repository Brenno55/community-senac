const input = document.getElementById('imagemUsuario');
const imagemPreview = document.getElementById('previaDaImagem');

const handlePhone = (event) => {

  let input = event.target
  input.value = phoneMask(input.value)

}

const phoneMask = (value) => {

  if (!value) return ""
  value = value.replace(/\D/g,'')
  value = value.replace(/(\d{2})(\d)/,"($1) $2")
  value = value.replace(/(\d)(\d{4})$/,"$1-$2")

  return value

}

input.addEventListener('change', (event) => {
  const arquivo = event.target.files[0];

  const leitor = new FileReader();
  leitor.readAsDataURL(arquivo);

  leitor.addEventListener('load', (event) => {
    const conteudo = event.target.result;
    imagemPreview.src = conteudo;


  });
});
