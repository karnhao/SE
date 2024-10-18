package printer

type Laser struct {
	Name string
}

func NewLaser(name string) *Laser {
	return &Laser{
		Name: name,
	}
}
