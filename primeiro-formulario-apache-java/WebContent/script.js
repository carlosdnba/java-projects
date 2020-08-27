document.addEventListener('DOMContentLoaded', () => {
    let submit = document.getElementById('submit');
    
    submit.addEventListener('click', () => {
        let name = document.getElementById('name').value;
        let login = document.getElementById('login').value;
        let password = document.getElementById('password').value;
        
        if (name.length < 3 ) {
            window.alert('Nome inválido.');
        }

        if (login.length < 3 ) {
            window.alert('Login inválido.');
        }

        if (password.length < 3 ) {
            window.alert('Senha inválida.');
        }
    });
});