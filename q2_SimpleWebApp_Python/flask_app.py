from flask import Flask, render_template, request, redirect, flash
from tinydb import TinyDB, where
from validate_email import validate_email

app = Flask(__name__)
app.config.update({"SECRET_KEY": "dynamicsolutioninnovators"})
db = TinyDB('db.json')

@app.route("/")
def home():
    return render_template("index.html")

@app.route("/about")
def about():
    return render_template("about.html")

@app.errorhandler(404)
def page_not_found(e):
    return render_template("error.html"), 404

###  USER AUTH ###

@app.route("/login", methods=["GET", "POST"])
def login():
    if request.method == "POST":
        email = request.form['email']
        email_is_valid = validate_email(email)
        password = request.form['password']
        
        # validation
        if email=='' or password=='':
            flash('Login failed! Required form fields empty.')
            return redirect('/login')
        elif  not email_is_valid:
            flash('Email address not valid! Please try again.')
            return redirect('/login')
        else:
            user = db.search(where('email')==email and where('password')==password)
            if len(user)>0:
                return redirect('/hello?user={}'.format(user[0].doc_id))
            else:
                flash('The email and password dont match any account.')
                return redirect('/login')
    else:
        return render_template("login.html")

@app.route("/signup", methods=["GET", "POST"])
def signup():
    if request.method == "POST":
        name = request.form['name']
        email = request.form['email']
        email_is_valid = validate_email(email)
        password = request.form['password']
        language = request.form['language']
        
        # validation
        if name=='' or email=='' or password=='':
            flash('Sign up failed! Required form fields empty.')
            return redirect('/signup')
        elif  not email_is_valid:
            flash('Email address not valid! Please try again')
            return redirect('/signup')
        else:
            db.insert({'name': name, 'email': email, 'password': password, 'language': language})
            flash(f'Sign up Done! You can now Login.')
            return redirect('/login')
    else:
        return render_template("signup.html")

### LANDING ###

@app.route("/hello")
def welc():
    return render_template("landing.html")

###

if __name__ == "__main__":
    app.run(debug=1)

###