# def main():
#     print("print somethign")
#     x = 'Knightfall is awesome'
#     print(x[::-1])
#     print(x.upper())
#     print(x.lower())
#     print(x.strip())
#     print(x.split())
#     print(x.replace('awesome','cool'))
#
# x = 'global'
# def function():
#     x = 'enclosing'
#     def g ():
#         x = 'local'
#     g()
#     print(x)
# function()
# print(x)

# def f():
#     x = 'enclosing'
#     def g():
#         x = 'local'
#         print(x)
#     g()
# f()

print(globals())
def f(x,y):
    s = 'foo'
    print(locals())
f(10,0.5)
